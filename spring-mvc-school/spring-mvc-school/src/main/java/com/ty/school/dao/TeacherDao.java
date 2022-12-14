package com.ty.school.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.school.dto.Student;
import com.ty.school.dto.Teacher;

@Component
public class TeacherDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	
	public Teacher saveTeacher(Teacher teacher) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(teacher);
		entityTransaction.commit();
		return teacher;
	}
	public Teacher getTeacherById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager.find(Teacher.class, id);
		
	}
	public List<Teacher> getAllTeacher() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("SELECT t FROM Teacher t");
		return query.getResultList();
	}
	public Teacher updateTeacherById(int id,Teacher teacher) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Teacher teacher2=entityManager.find(Teacher.class, id);
		teacher2.setId(teacher.getId());
		teacher2.setName(teacher.getName());
		teacher2.setEmail(teacher.getEmail());
		teacher2.setAge(teacher.getAge());
		teacher2.setPhone(teacher.getPhone());
		teacher2.setSub(teacher.getSub());;
		
		entityTransaction.begin();
		entityManager.merge(teacher2);
		entityTransaction.commit();
		return teacher2;
	}
	public boolean deleteTeacherById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Teacher teacher=entityManager.find(Teacher.class, id);
		entityTransaction.begin();
		if(teacher != null) {
			entityManager.remove(teacher);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}
}
