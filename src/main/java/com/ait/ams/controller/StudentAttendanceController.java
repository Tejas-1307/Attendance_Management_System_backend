package com.ait.ams.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.ams.model.Student;
import com.ait.ams.model.Student_Attendance;
import com.ait.ams.service.StudentAttendanceService;

@RestController
@RequestMapping("/student_attendance")
@CrossOrigin("*")
public class StudentAttendanceController {
	
	@Autowired
	private StudentAttendanceService stuAttService;
	
	// this is to format date and time
	
//	LocalDate myObj = LocalDate.now(); 
//	String date = myObj.toString();
//    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//    String formattedDate = myObj.format(myFormatObj);
	
	Date myDate = new Date();
	String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(myDate);
	String formattedTime = new SimpleDateFormat("hh:mm:ss").format(myDate);
    
//    LocalTime myObj1 = LocalTime.now();
//    String time = myObj1.toString();
//    DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("hh:mm:ss");
//    String formattedTime = myObj1.format(myFormatObj1);

    
	// To save attendance for particular student
    
	@PostMapping("/{rollNo}")
	public ResponseEntity<String> markAttendance(@RequestBody Student_Attendance stuatt, @PathVariable("rollNo") int rollNo){
		stuatt.setDate(formattedDate);
		stuatt.setTime(formattedTime);
		
		//  getting student attendance by date to check if attendance is already marked for student.
		Student_Attendance st_att = stuAttService.getStudentAttendanceByDate(rollNo, formattedDate);
		
		if(st_att != null && !st_att.getAttendance().equalsIgnoreCase(stuatt.getAttendance())) {	
			 st_att.setAttendance(stuatt.getAttendance());
			 Student st = stuAttService.markAttendance(rollNo, st_att);
			 return ResponseEntity.status(HttpStatus.CREATED).body("Attendance marked successfully.....");
			 
		}else if(st_att != null && st_att.getAttendance().equalsIgnoreCase(stuatt.getAttendance()) && st_att.getAttendance() != "" && st_att.getAttendance() != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Attendance already marked ! cannot mark twice....");
		}
		
		Student st = stuAttService.markAttendance(rollNo, stuatt);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Attendance marked successfully.....");
	}
}


