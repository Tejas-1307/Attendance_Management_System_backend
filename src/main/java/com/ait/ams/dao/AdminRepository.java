package com.ait.ams.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.ams.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>{
		public Admin findByName(String name);
}
