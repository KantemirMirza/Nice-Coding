package com.example.nicecoding.parameter.repository;

import com.example.nicecoding.parameter.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
