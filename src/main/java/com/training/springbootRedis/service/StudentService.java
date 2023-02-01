package com.training.springbootRedis.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.training.springbootRedis.model.Student;

import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class StudentService {
	
	public static HashMap<String, Object> map = new HashMap<>();
	
	@CachePut(value = "students", key = "#student.id")
	public Student save(Student student) {
		log.info("saving student" + student);
		map.put(student.getId(), student);
		return student;
	}
	
	@Cacheable(value="students", key="#id")
	public Student find(String id) {
		log.info("find student id" + id);
		return (Student)map.get(id);
	}
	
	@CacheEvict(value = "students",  key = "#id")
	public void delete(String id) {
		log.info("delete student id" + id);
		map.remove(id);
	}
	
    public List<Student> findAll() {
    	return null;
    }
	
}
