package com.example.dbtest.models.repository;

import com.example.dbtest.models.VisitEntity;
import org.springframework.data.repository.CrudRepository;



public interface VisitRepository extends CrudRepository<VisitEntity, Long> {
}
