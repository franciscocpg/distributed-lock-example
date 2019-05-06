package com.github.alturkovic.lock.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sequences")
public class Sequence {
    @Id
    private String name;

    private long sequence;

    public Sequence() {

    }

    public Sequence(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String id) {
        this.name = id;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }
}