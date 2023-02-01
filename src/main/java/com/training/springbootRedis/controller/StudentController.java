package com.training.springbootRedis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.springbootRedis.model.Student;
import com.training.springbootRedis.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/save")
	public Student save(@RequestBody Student student){
		return studentService.save(student);
	}
	
	@GetMapping("/find/{id}")
	public Student find(@PathVariable String id) {
		return studentService.find(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable String id) {
		studentService.delete(id);
	}
	
	public void findAll() {
		
	}
}
