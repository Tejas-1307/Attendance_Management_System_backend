package com.ait.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.ams.dao.TeacherRepository;
import com.ait.ams.model.Teacher;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	// get teacher by email
	public Teacher getTeacherByEmail(String email) {
			Teacher t = teacherRepo.findByEmail(email);
			return t;
	}
	
	// add new teacher
	public Teacher addTeacher(Teacher t) {
		Teacher teacher = teacherRepo.save(t);
		return teacher;
	}
	
	// get all teachers
	public List<Teacher> getAllTeachers(){
		List<Teacher> teachers = teacherRepo.findAll();
		return teachers;
	}
	
	// delete teacher by id
	public void deleteTeacher(String email) {
		teacherRepo.deleteById(email);
	}
	
	// get count of all teachers
	public long countOfTeachers() {
		return teacherRepo.count();
	}
	
}
