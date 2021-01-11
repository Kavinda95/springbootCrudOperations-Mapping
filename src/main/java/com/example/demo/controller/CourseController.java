package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService service;

	//Adding
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		return service.saveCourse(course);
	}
	
	 //Deleting
    @DeleteMapping("/course/{id}")
    public String deleteCourse(@PathVariable long id){
        return service.deleteCourse(id);
    }
    
    // View all data on the DB
    @GetMapping("course/getall")
    public List<Course> findAllCourses(){
        return service.getCourses();
    }
    
    //Updating
    @PutMapping("/update/course")
    public Course updateCourse(@RequestBody Course course) {
        return service.updateCourse(course);
    }
    
}


