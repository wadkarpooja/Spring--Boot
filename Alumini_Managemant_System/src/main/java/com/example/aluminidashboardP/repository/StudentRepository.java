package com.example.aluminidashboardP.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aluminidashboardP.entity.Student;
public interface StudentRepository extends JpaRepository<Student, Integer> {
	List<Student> findByNameContaining(String name);
	List<Student> findBygrdYearContaining(String grdYear);
	
}
