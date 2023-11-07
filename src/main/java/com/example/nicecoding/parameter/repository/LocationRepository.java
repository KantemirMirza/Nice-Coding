package com.example.nicecoding.parameter.repository;

import com.example.nicecoding.parameter.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
