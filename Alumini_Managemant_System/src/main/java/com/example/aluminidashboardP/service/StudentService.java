package com.example.aluminidashboardP.service;

import java.util.List;

import com.example.aluminidashboardP.entity.Student;
import com.example.aluminidashboardP.studentDTO.StudentDTO;

public interface StudentService {
	List<Student> getAllStudent();
	
	Student createStudent(StudentDTO studentDTO);
	
	Student updateStudent(int id,StudentDTO studentDTO);
	
	Student getAllStudentById(int id);
	
	List<Student> findByNameContaining(String name);
	
	List<Student> findByGrdYearContaining(String grdYear);
	
	String deleteStudent(int id);

}