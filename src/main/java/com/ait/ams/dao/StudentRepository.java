package com.ait.ams.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ait.ams.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	public Student findByEmail(String email);
	
	public List<Student> findAllByStandard(String std);
	
	
	@Query(value="select * from student s join student_attendance sa on s.roll_no = sa.student_rollno where sa.date =:dt", nativeQuery=true)
	public List<Student> getStudentsByDate(@Param("dt") String date);
}
