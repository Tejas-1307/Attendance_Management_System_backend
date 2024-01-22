package com.ait.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.ait.ams.model.Student;
import com.ait.ams.model.Teacher;
import com.ait.ams.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	// Login student
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Student student){
	  try {
          Student st = studentService.getStudentByEmail(student.getEmail());
          
		  if(st != null && student.getEmail().equals(st.getEmail()) && student.getPassword().equals(st.getPassword())) {
				return ResponseEntity.status(HttpStatus.OK).body("Student Login successful");
		  }else {
			    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Student Login failed ! invalid credentials");
		  }
	  }catch(Exception e) {
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong "+e.getMessage());
	  }
	}
	
	
	
	// add new student or register student
	
	@PostMapping("/")
	public ResponseEntity<String> addStudent(@RequestBody Student student){
		Student s = studentService.getStudentByEmail(student.getEmail());
		if(s != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Student already exist with this email id...");
		}
		
		Student st = studentService.addStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body("Student added successfully...");
	}
	
	
	   // get all students
	
		@GetMapping("/")
		public ResponseEntity<List<Student>> getAllStudents(){
			List<Student> students = studentService.getAllStudents();
			return ResponseEntity.status(HttpStatus.OK).body(students);
		}
		
		// get student by roll no.
		@GetMapping("/getbyrollno/{rollNo}")
		public ResponseEntity<Student> getStudentByRollNo(@PathVariable("rollNo") int rollNo){
			Student st = studentService.getStudentByRollNo(rollNo);
			return ResponseEntity.status(HttpStatus.OK).body(st);
		}
		
		
		// get student by email
		@GetMapping("/getbyemail/{email}")
		public ResponseEntity<Student> getStudentByEmail(@PathVariable("email") String email){
			Student st = studentService.getStudentByEmail(email);
			return ResponseEntity.status(HttpStatus.OK).body(st);
		}

		
		
		 // get all students by class
		@GetMapping("/getbyclass/{std}")
		public ResponseEntity<List<Student>> getStudentsByStandard(@PathVariable("std") String std){
			List<Student> students = studentService.getStudentsByStandard(std);
			return ResponseEntity.status(HttpStatus.OK).body(students); 
		}
		
		
		// get students by date
		
		@GetMapping("/getbydate/{date}")
		public ResponseEntity<List<Student>> getStudentsByDate(@PathVariable("date") String date){
			List<Student> students = studentService.getStudentsByDate(date);
			return ResponseEntity.status(HttpStatus.OK).body(students);
		}
		
		
		// update student details
		
		@PutMapping("/update")
		public ResponseEntity<Student> updateStudent(@RequestBody Student student){
			Student st = studentService.addStudent(student);
			return ResponseEntity.status(HttpStatus.OK).body(st);
		}
		
		
		//delete student by roll no.
		
		@DeleteMapping("/delete/{rollNo}")
		public ResponseEntity<String> deleteStudent(@PathVariable("rollNo") int rollNo){
			studentService.deleteStudent(rollNo);
			return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully...");
		}
		
		
		// get count of students
		@GetMapping("/count")
		public ResponseEntity<Long> countOfStudents(){
			long count = studentService.countOfStudents();
			return ResponseEntity.status(HttpStatus.OK).body(count);
		}
}




