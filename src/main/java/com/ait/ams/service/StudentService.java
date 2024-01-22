package com.ait.ams.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.ams.dao.StudentRepository;
import com.ait.ams.model.Student;
import com.ait.ams.model.Student_Attendance;
import com.ait.ams.model.Teacher;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	// add new student
	public Student addStudent(Student st) {
			Student student = studentRepo.save(st);
			return student;
	}
	
	// get all students
	public List<Student> getAllStudents(){
			List<Student> students = studentRepo.findAll();
			return students;
	}
	
	// get student by roll no
	public Student getStudentByRollNo(int rollNo) {
		Student student = studentRepo.findById(rollNo).get();
		return student;
	}
	
	  // get student by email
		public Student getStudentByEmail(String email) {
			Student student = studentRepo.findByEmail(email);
			return student;
		}
		
	  // get all students by class
		public List<Student> getStudentsByStandard(String std){
			List<Student> students = studentRepo.findAllByStandard(std);
			return students;
		}
		
		// get students by attendance date
		public List<Student> getStudentsByDate(String date){
			List<Student> students = studentRepo.getStudentsByDate(date);
			for(Student st : students) {
			    List<Student_Attendance> statt =	st.getAttendance();
			    for(Student_Attendance sa : statt) {
			    	if(sa.getDate().equals(date)) {
			    		List<Student_Attendance> stat = new ArrayList<>();
			    		stat.add(sa);
			    		statt=stat;
			    	}
			    }
			    st.setAttendance(statt);
			}
			
			return students;
		}
	
	// delete student by id
		public void deleteStudent(int rollNo) {
			studentRepo.deleteById(rollNo);
		}
	
		
		// get count of students
		public long countOfStudents() {
			return studentRepo.count();
		}
		
		
	
}
