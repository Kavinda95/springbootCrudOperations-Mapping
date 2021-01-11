package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	
	//Adding Student
	public Student saveStudent(Student student , Course course) {
	course.getStudents().add(student);
		student.setCourse(course);
	return repository.save(student);
	}
		//View all Student
	  public List<Student> getStudents(){
	        return repository.findAll();
	    }
	  
		 //Deleting Student
	    public String deleteStudent(long  id){
	        repository.deleteById(id);
	        return "Successfully Deleted Student..." +id;
	    }
	    
	    
}