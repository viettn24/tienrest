package com.tiendt.springrest.dao;

import java.util.List;

import com.tiendt.springrest.entity.Student;

public interface StudentDAO {
	
	public List<Student> getStudents();

	public Student getStudent(int studentId);

	public void addStudent(Student theStudent);

	public void updateStudent(Student theStudent);

	public void deleteStudent(int studentId);
	
	
	
	
	
	
	
	
}










