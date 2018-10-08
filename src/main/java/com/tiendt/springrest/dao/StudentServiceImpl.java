package com.tiendt.springrest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiendt.springrest.entity.Student;

@Repository
public class StudentServiceImpl implements StudentServiceDAO {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentDAO.getStudents();
	}

	@Override
	@Transactional
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		return studentDAO.getStudent(studentId);
	}

	@Override
	@Transactional
	public void addStudent(Student theStudent) {
		studentDAO.addStudent(theStudent);
		
	}

	@Override
	@Transactional
	public void updateStudent(Student theStudent) {
		studentDAO.updateStudent(theStudent);
		
	}

	@Override
	@Transactional
	public void deleteStudent(int studentId) {
		studentDAO.deleteStudent(studentId);
		
	}

}
