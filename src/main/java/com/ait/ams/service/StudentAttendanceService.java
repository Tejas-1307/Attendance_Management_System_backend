package com.ait.ams.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.ams.dao.StudentAttendanceRepository;
import com.ait.ams.model.Student;
import com.ait.ams.model.Student_Attendance;

@Service
public class StudentAttendanceService {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentAttendanceRepository stuAttRepo;
	
	
	// To save attendance for particular student
	
		public Student markAttendance(int rollNo, Student_Attendance stuatt) {
			
			Student st = studentService.getStudentByRollNo(rollNo);
			stuatt.setStudent(st);
						
			List<Student_Attendance> attendance = new ArrayList<Student_Attendance>();
			attendance.add(stuatt);
			
			st.setAttendance(attendance);
			
			Student student = stuAttRepo.save(st);
			
			return student; 	
		}
		
		// To get student attendance by date
		
		public Student_Attendance getStudentAttendanceByDate(int rollNo, String date) {
			
			Student st = stuAttRepo.getStudentByDate(date, rollNo);
			
			
			
			if(st != null) {
				

				  Student_Attendance st_att = st.getAttendance().get(st.getAttendance().size()-1);
				  System.out.println(st_att.getDate());
				  return st_att;
			}
			
			return null;
		}
	
	
}
