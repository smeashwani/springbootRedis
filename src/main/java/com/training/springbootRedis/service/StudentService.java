package com.training.springbootRedis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springbootRedis.model.Student;
import com.training.springbootRedis.repo.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public void save(Student student) {
		studentRepository.save(student);
	}
	
	public Student find(String id) {
		return studentRepository.findById(id).get();
	}
	
	
	
	public void delete(String id) {
		studentRepository.deleteById(id);
	}
	
	public List<Student> findAll() {
		return (List<Student>) studentRepository.findAll();	
	}

}
