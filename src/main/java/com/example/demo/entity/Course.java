package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "course_duration")
	private String courseDuration;
	
	@OneToMany(mappedBy = "course")
	private Set<Student> students = new HashSet<>();
	@OneToMany(mappedBy = "course")
	private Set<Teacher> teachers = new HashSet<>();
	
    public Course() {
		
	 	}
	

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}


	public Set<Student> getStudents() {
		return students;
	}


	public void setStudents(Set<Student> students) {
		this.students = students;
	}


	public Set<Teacher> getTeachers() {
		return teachers;
	}


	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
}
