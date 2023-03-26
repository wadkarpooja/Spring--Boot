package com.example.aluminidashboardP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.aluminidashboardP.entity.Student;
import com.example.aluminidashboardP.repository.StudentRepository;

@SpringBootApplication
public class AluminiDashboardP implements CommandLineRunner{
@Autowired
private StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(AluminiDashboardP.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Student a1=Student.builder().name("pranjal").phone("9876543234").email("A@gmail.com").grdYear("2023").build();
		Student a2=Student.builder().name("prtik").phone("9876543244").email("B@gmail.com").grdYear("2021").build();
		Student a3=Student.builder().name("pooja").phone("9876543233").email("C@gmail.com").grdYear("2022").build();
		Student a4=Student.builder().name("jayshri").phone("987654322").email("T@gmail.com").grdYear("2024").build();
		
		studentRepository.save(a1);
		studentRepository.save(a2);
		studentRepository.save(a3);
		studentRepository.save(a4);
	}

}
