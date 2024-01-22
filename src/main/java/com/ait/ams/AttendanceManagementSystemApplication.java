package com.ait.ams;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AttendanceManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceManagementSystemApplication.class, args);
		
		Date myDate = new Date();
		System.out.println(myDate);
		System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(myDate));
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(myDate));
		System.out.println(myDate);
		String time = new SimpleDateFormat("hh:mm:ss").format(myDate);
		System.out.println(time);
	    
	}

}

