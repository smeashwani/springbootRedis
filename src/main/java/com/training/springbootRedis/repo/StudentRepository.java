package com.training.springbootRedis.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.springbootRedis.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
}