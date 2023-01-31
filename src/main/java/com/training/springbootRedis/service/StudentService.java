package com.training.springbootRedis.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import com.training.springbootRedis.model.Student;

@Service
public class StudentService {
	
	private final String hashReference= "Student";
	
	
	@Resource(name="redisTemplate")
	private HashOperations<String, String, Object> hashOperations;
	
	public void save(Student student) {
		hashOperations.put(hashReference, student.getId(), student);
	}
	
	public Student find(String id) {
		return (Student)hashOperations.get(hashReference, id);
	}
	
	public void delete(String id) {
		hashOperations.delete(hashReference, id);
	}
	
    public Map<String, Object> findAll() {
       return hashOperations.entries(hashReference);
    }
	
}
