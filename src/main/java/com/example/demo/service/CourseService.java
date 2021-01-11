package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repository;
	
	public Course saveCourse(Course course) {
		return repository.save(course);
	}
	public Course findById(Long courseId){
		Optional<Course> optionalCourse=  repository.findById(courseId);
		if(optionalCourse.isPresent()){
			return optionalCourse.get();
		}
			return null;
	}
	
	 //Deleting Method
    public String deleteCourse(long  id){
        repository.deleteById(id);
        return "Successfully Deleted Course..." +id;
    }
    
    public List<Course> getCourses(){
        return repository.findAll();
    }
    
    //Updating Method
    public Course updateCourse(Course course){
    	Course existitingCourse=repository.findById(course.getId()).orElse(null);
        existitingCourse.setCourseName(course.getCourseName());
        existitingCourse.setCourseDuration(course.getCourseDuration());
        return repository.save(existitingCourse);
    }
}

	


