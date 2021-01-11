package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository repository;
	
	public Teacher saveTeacher(Teacher teacher) {
		return repository.save(teacher);
}
	//Finding Teacher By Id
	public Teacher findById(Long teacherId){
	Optional<Teacher> optionalTeacher=  repository.findById(teacherId);
	if(optionalTeacher.isPresent()){
		return optionalTeacher.get();
	}
		return null;
}

//Saving Teacher with Course Id
public Teacher saveTeacher(Teacher teacher , Course course) {
	course.getTeachers().add(teacher);
		teacher.setCourse(course);
	return repository.save(teacher);
	}

//View all teachers
public List<Teacher> getTeachers(){
    return repository.findAll();
}


//Deleting Teacher
public String deleteTeacher(long  id){
    repository.deleteById(id);
    return "Successfully Deleted Teacher..." +id;
}

}
