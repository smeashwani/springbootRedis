package com.training.springbootRedis;

import java.util.List;
//$ docker run -p 16379:6379 -d redis:6.0 redis-server --requirepass "mypass"

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.springbootRedis.model.Student;
import com.training.springbootRedis.service.StudentService;

@SpringBootApplication
public class SpringbootRedisApplication implements CommandLineRunner{
	
	@Autowired
	StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRedisApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Student stu1 = new Student("1", "STU_1", Student.Gender.MALE, 1);
		studentService.save(stu1);
		
		Student stu2 = new Student("2", "STU_2", Student.Gender.FEMALE, 2);
		studentService.save(stu2);
		 
		List<Student> findAll = studentService.findAll();
		System.out.println(findAll);
		
		studentService.delete("2");
		
		stu1.setGrade(20);
		studentService.save(stu1);
		
		findAll = studentService.findAll();
		System.out.println(findAll);
	}

}
