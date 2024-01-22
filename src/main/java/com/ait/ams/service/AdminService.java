package com.ait.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.ams.dao.AdminRepository;
import com.ait.ams.model.Admin;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepo;
	
	// to login the admin
	public Admin getAdminByName(String name) {
		
		Admin admin = adminRepo.findByName(name);
//		Admin admin = null;
//		try {
//			admin = list.get(0);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		return admin;

	}
}
