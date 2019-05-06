# Example application

This application will create a REST endpoint `/hello/{name}` which will call a JDBC locked service.
The locks are kept in a postgres database.

It demonstrates a basic distributed lock using https://github.com/alturkovic/distributed-lock.

### Bootstraping database
```bash
docker run -d --name=distributed-lock-example -p 5432:5432 postgres

until docker logs distributed-lock-example | grep 'database system is ready to accept connections'; do; sleep 0.1; done;

docker exec -it distributed-lock-example psql -U postgres -c "
create database test;
"

docker exec -it distributed-lock-example psql -U postgres -c "
create user test with login password 'test';
alter database test owner to test;
"

docker exec -it distributed-lock-example psql -U test -c "
create table lock (
    id serial primary key,
    lock_key varchar(255) unique,
    token varchar(255),
    expireAt timestamp
);
"
```

### Running

Open two terminal sessions and run each instance on a different port. Eg:

#### Instance 1
```bash
mvn -Dserver.port=8080 spring-boot:run
```

#### Instance 2
```bash
mvn -Dserver.port=8081 spring-boot:run
```

Then make some requests to these instances in parallel. Eg:

#### Instance 1
```bash
curl localhost:8080/hello/chico
```

#### Instance 2
```bash
curl localhost:8081/hello/chico
```
