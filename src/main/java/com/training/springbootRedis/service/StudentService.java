package com.training.springbootRedis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.training.springbootRedis.model.Student;

@Service
public class StudentService {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	public void save(Student student) {
		 redisTemplate.opsForValue().set(student.getId(), student);
	}
	
	public Student find(String id) {
		return (Student)redisTemplate.opsForValue().get(id);
	}
	
	
	
	public void delete(String id) {
		redisTemplate.delete(id);
	}
	
}
