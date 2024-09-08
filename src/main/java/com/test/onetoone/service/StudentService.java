package com.test.onetoone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.onetoone.entities.Student;
import com.test.onetoone.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo sturepo;
	
	public Student addStudent(@RequestBody Student stu)
	{
		return sturepo.save(stu);
	}
	
	public List<Student> getStudent()
	{
		List<Student> ls = sturepo.findAll();
		return ls;
	}
	
	public Student getOneStudent(@PathVariable int id)
	{
		Student obj = sturepo.findById(id).get();
		return obj;
	}
	
	public Student updateStudent(@RequestBody Student nstu,@PathVariable int sid)
	{
		Student ostu = sturepo.findById(sid).get();
		if(ostu!=null)
		{
			ostu.setName(nstu.getName());
			ostu.setCity(nstu.getCity());
			sturepo.save(ostu);
		}
		return ostu;
		
	}
	
	public String deleteStudent(@PathVariable int id)
	{
		Student stu = sturepo.findById(id).get();
		sturepo.delete(stu);
		return "Student "+id+" Deleted..";
	}
}
