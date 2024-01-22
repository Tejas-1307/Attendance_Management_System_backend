package com.ait.ams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.ams.model.Admin;
import com.ait.ams.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Admin admin){
		Admin admin1 = adminService.getAdminByName(admin.getName());
		
		if(admin1 != null && admin.getName().equals(admin1.getName()) && admin.getPassword().equals(admin1.getPassword())) {
				return ResponseEntity.status(HttpStatus.OK).body("Login successful");
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed ! invalid credentials");
		}
	}
	
}
