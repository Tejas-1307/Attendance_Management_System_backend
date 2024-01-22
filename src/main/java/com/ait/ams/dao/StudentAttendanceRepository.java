package com.ait.ams.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ait.ams.model.Student;
import com.ait.ams.model.Student_Attendance;

public interface StudentAttendanceRepository extends JpaRepository<Student, Integer>{

	@Query(value="select * from student s join student_attendance sa on s.roll_no = sa.student_rollno where sa.date =:dt and s.roll_no =:rno order by sa.attendance_id desc limit 1", nativeQuery=true)
	public Student getStudentByDate(@Param("dt") String date, @Param("rno") int rollNo);
		
}

