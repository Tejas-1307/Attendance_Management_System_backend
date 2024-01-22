package com.ait.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.ams.model.Teacher;
import com.ait.ams.service.TeacherService;

@RestController
@RequestMapping("/teacher")
@CrossOrigin("*")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	// login teacher
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Teacher teacher){
		Teacher t = teacherService.getTeacherByEmail(teacher.getEmail());
		
		if(t != null && teacher.getEmail().equals(t.getEmail()) && teacher.getPassword().equals(t.getPassword())) {
				return ResponseEntity.status(HttpStatus.OK).body("Teacher Login successful");
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Teacher Login failed ! invalid credentials");
		}
	}
	
	// Add new teacher
	
	@PostMapping("/")
	public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){
		
		Teacher t1 = teacherService.getTeacherByEmail(teacher.getEmail());
		if(t1 != null) {
			// 409 conflict
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Teacher already exist with this email id...");
		}
		
		Teacher t = teacherService.addTeacher(teacher);
		return ResponseEntity.status(HttpStatus.CREATED).body("Teacher added successfully...");
	}
	
	// get all teachers
	
	@GetMapping("/")
	public ResponseEntity<List<Teacher>> getAllTeachers(){
		List<Teacher> teachers = teacherService.getAllTeachers();
		return ResponseEntity.status(HttpStatus.OK).body(teachers);
	}
	
	
	// get teacher by email
	@GetMapping("/getbyemail/{email}")
	public ResponseEntity<Teacher> getTeacherByEmail(@PathVariable("email") String email){
			Teacher t = teacherService.getTeacherByEmail(email);
			return ResponseEntity.status(HttpStatus.OK).body(t);
	}
	
	
	// update teacher details
	
	@PutMapping("/update")
	public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher){
		Teacher t = teacherService.addTeacher(teacher);
		return ResponseEntity.status(HttpStatus.OK).body(t);
	}
	
	
	//delete teacher by id
	@DeleteMapping("/delete/{email}")
	public ResponseEntity<String> deleteTeacher(@PathVariable("email") String email){
		teacherService.deleteTeacher(email);
		return ResponseEntity.status(HttpStatus.OK).body("Teacher deleted successfully...");
	}
	
	// get count of all teachers
	@GetMapping("/count")
	public ResponseEntity<Long> countOfTeachers(){
		long count = teacherService.countOfTeachers();
		return ResponseEntity.status(HttpStatus.OK).body(count);
	}
	
}
