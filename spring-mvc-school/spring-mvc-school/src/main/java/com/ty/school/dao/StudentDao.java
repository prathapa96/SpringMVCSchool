package com.ty.school.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.school.dto.Student;

@Component
public class StudentDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	
	public Student saveStudent(Student student) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}
	public Student getStudentById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager.find(Student.class, id);
		
	}
	public List<Student> getAllStudent() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("SELECT s FROM Student s");
		return query.getResultList();
	}
	public Student updateStudentById(int id,Student student) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student student2=entityManager.find(Student.class, id);
		student2.setId(student.getId());
		student2.setName(student.getName());
		student2.setEmail(student.getEmail());
		student2.setAge(student.getAge());
		student2.setC_no(student.getC_no());
		student2.setGender(student.getGender());
		
		entityTransaction.begin();
		entityManager.merge(student2);
		entityTransaction.commit();
		return student2;
	}
	public boolean deleteStudentById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student student=entityManager.find(Student.class, id);
		entityTransaction.begin();
		if(student != null) {
			entityManager.remove(student);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}
}
