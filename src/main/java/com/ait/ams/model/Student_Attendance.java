package com.ait.ams.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Student_Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int attendanceId;
	
	private String date;
	
	private String time;
	
	private String attendance;
	
	@ManyToOne
	@JoinColumn(name = "student_rollno")
	@JsonBackReference
	private Student student;

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Student_Attendance [attendanceId=" + attendanceId + ", date=" + date + ", time=" + time
				+ ", attendance=" + attendance + ", student=" + student + "]";
	}
	
	
}
