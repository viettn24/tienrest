package com.tiendt.springrest.controller;

import java.util.ArrayList;
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

import com.tiendt.springrest.dao.StudentDAO;
import com.tiendt.springrest.dao.StudentServiceDAO;
import com.tiendt.springrest.entity.Student;
import com.tiendt.springrest.rest.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class AppController {
	
	@Autowired
	private StudentServiceDAO studentServiceDAO;
	
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> theStudents = new ArrayList<>();
		
		theStudents = studentServiceDAO.getStudents();
		
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		Student theStudent = new Student();
		
		theStudent = studentServiceDAO.getStudent(studentId);
		
		if(theStudent == null) {
			throw new StudentNotFoundException("Student not found - " +studentId);
		}
		
		return theStudent;
	}
	
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student theStudent) {
		
		theStudent.setId(0);
		studentServiceDAO.addStudent(theStudent);
		
		return theStudent;
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student theStudent) {
		
		studentServiceDAO.updateStudent(theStudent);
		
		return theStudent;
	}
	
	
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {
		
		studentServiceDAO.deleteStudent(studentId);
		
		return "Student is deleted - " +studentId;
	}
	
}









