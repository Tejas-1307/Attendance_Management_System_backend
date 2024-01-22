package com.ait.ams.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollNo;
	@Column(unique = true,nullable=false, length=50)
	private String email;
	@Column(nullable=false, length=10)
	private String standard;
	@Column(nullable=false, length=50)
	private String name;
	@Column(nullable=false)
	private String address;
	@Column(unique = true,nullable=false, length=10)
	private String mobile;
	@Column(nullable=false)
	private String password;
	
	
	@OneToMany(mappedBy = "student",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonManagedReference
	private List<Student_Attendance> attendance;
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Student_Attendance> getAttendance() {
		return attendance;
	}
	public void setAttendance(List<Student_Attendance> attendance) {
		this.attendance = attendance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", address=" + address + ", mobile=" + mobile
				+ ", password=" + password + ", attendance=" + attendance + "]";
	}
	
	
}
