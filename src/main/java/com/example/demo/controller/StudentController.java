package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;
	
	//Add student with courseID
	@PostMapping("/student/{courseId}")
	public Student addStudent(@PathVariable("courseId") Long courseId ,@RequestBody Student student) {
		Course course =  courseService.findById(courseId);
		return studentService.saveStudent(student,course);
		}
		
	// View all data on the DB
    @GetMapping("/getallStudents")
    public List<Student> findAllStudents(){
        return studentService.getStudents();
    }
					

	 //Deleting
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }
	
}
    

