package com.tiendt.springrest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tiendt.springrest.entity.Student;

@Repository
public class StudentImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Student> getStudents() {
		List<Student> theStudents = new ArrayList<>();
		
		Session session = sessionFactory.getCurrentSession();
		Query<Student> theQuery = session.createQuery("from Student",Student.class);
		
		theStudents = theQuery.getResultList();
		
		
		return theStudents;
	}

	@Override
	public Student getStudent(int studentId) {
		Student theStudent = new Student();
		
		Session session = sessionFactory.getCurrentSession();
		
		String querySingle = "from Student E where E.id=" +studentId ;
		
		Query<Student> theQuery = session.createQuery(querySingle,Student.class);
		
		theStudent = theQuery.getSingleResult();
		
		return theStudent;
	}

	@Override
	public void addStudent(Student theStudent) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theStudent);
		
	}

	@Override
	public void updateStudent(Student theStudent) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theStudent);
		
	}

	@Override
	public void deleteStudent(int studentId) {

		Session session = sessionFactory.getCurrentSession();
		String deleteQuery = "DELETE FROM Student WHERE id= :student_id";
		
		Query theQuery = session.createQuery(deleteQuery);
		theQuery.setParameter("student_id", studentId);
		
		theQuery.executeUpdate();
		
	}

}









