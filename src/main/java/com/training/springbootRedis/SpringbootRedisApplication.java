package com.training.springbootRedis;

import java.util.Map;

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
		
		Student stu3 = new Student("3", "STU_3", Student.Gender.FEMALE, 3);
		studentService.save(stu3);
		
		Student find = studentService.find("2");
		System.out.println(find);
		
		studentService.delete("2");
		
		find = studentService.find("2");
		System.out.println(find);
		
		stu1.setGrade(20);
		studentService.save(stu1);
		
		find = studentService.find("1");
		System.out.println(find);
		System.out.println("=============FIND ALL=======");
		Map<String, Object> findAll = studentService.findAll();
		findAll.forEach( (k,v) -> {
			System.out.println("KEY: "+ k + " Value: "+v);
		});
	}

}
