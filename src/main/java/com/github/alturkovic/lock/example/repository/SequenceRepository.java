package com.github.alturkovic.lock.example.repository;

import com.github.alturkovic.lock.example.model.Sequence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceRepository extends JpaRepository<Sequence, String> {

}
