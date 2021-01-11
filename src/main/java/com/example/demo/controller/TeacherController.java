package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.service.CourseService;

import com.example.demo.service.TeacherService;

@RestController
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private CourseService courseService;
	
	//Adding teacher with course Id
	@PostMapping("/teacher/{courseId}")
	public Teacher addTeacher(@PathVariable("courseId") Long courseId ,@RequestBody Teacher teacher) {
		Course course = courseService.findById(courseId);
		return teacherService.saveTeacher(teacher, course);
		}
	
	//View all teachers
	 @GetMapping("/getallTeachers")
	    public List<Teacher> findAllTeachers(){
	        return teacherService.getTeachers();
	    }
	 
	 //Deleting
	    @DeleteMapping("/teacher/{id}")
	    public String deleteTeacher(@PathVariable long id){
	        return teacherService.deleteTeacher(id);
	    }
	
	 }



