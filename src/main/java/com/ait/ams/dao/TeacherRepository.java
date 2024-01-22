package com.ait.ams.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.ams.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String>{
		public Teacher findByEmail(String email);
}
