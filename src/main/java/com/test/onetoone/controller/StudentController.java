package com.test.onetoone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.test.onetoone.entities.Student;
import com.test.onetoone.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService stuser;
	
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student stu)
	{
		System.out.println("Student added..");
		return stuser.addStudent(stu);
	}
	
	@GetMapping("/get")
	public List<Student> getStudent()
	{
		return stuser.getStudent();
	}
	
	@GetMapping("/get/{id}")
	public Student getOneStudent(@PathVariable int id)
	{
		return stuser.getOneStudent(id);
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@RequestBody Student student,@PathVariable int id)
	{
		Student stu =stuser.updateStudent(student, id);
		System.out.println("Student updated..");
		return stu;
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteStudent(@PathVariable int id)
	{
		stuser.deleteStudent(id);
		return "Student "+id+" Deleted...";
	}
}
