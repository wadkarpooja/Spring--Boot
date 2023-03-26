package com.example.aluminidashboardP.controller;

import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.aluminidashboardP.entity.Student;
import com.example.aluminidashboardP.service.StudentService;
import com.example.aluminidashboardP.studentDTO.StudentDTO;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api")
public class StudentController {
  private StudentService studentService;
  
  @PostMapping("/students")
  public ResponseEntity<Student> createStudent(@RequestBody @Valid StudentDTO a){
	  Student a1=studentService.createStudent(a);
	  return new ResponseEntity<>(a1,HttpStatus.CREATED);
  }
  
  @PutMapping("/students/{id}")
  public ResponseEntity<Student> updateStudent(@PathVariable("id")int id,@RequestBody StudentDTO studentDTO)
  {
	  studentService.updateStudent(id, studentDTO);
	  return ResponseEntity.ok().body(studentService.updateStudent(id, studentDTO));
  }
  
  @GetMapping("/studentname")
  public ResponseEntity<List<Student>> getStudentByStd_Name(@RequestParam(required=false)String name){
	  List<Student> student=studentService.findByNameContaining(name);
	  return ResponseEntity.ok(student);
  }
  
  @GetMapping("/studentsgrade")
  public ResponseEntity<List<Student>> findByGrdYearContaining(@RequestParam(required = false) String grdYear){
	  List<Student> student=studentService.findByGrdYearContaining(grdYear);
	  return ResponseEntity.ok(student); 
  }
  
  @GetMapping("/students/{id}")
  public ResponseEntity<Student> getAllStudentBtId(@PathVariable int id)
  {
	  studentService.getAllStudentById(id);
	  return ResponseEntity.ok().body(studentService.getAllStudentById(id));
  }
  
  @DeleteMapping("/students/{id}")
  public ResponseEntity<Student> deleteStudent(@PathVariable int id){
	  studentService.deleteStudent(id);
	  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  @GetMapping("/students")
  public ResponseEntity<List<Student>> fetchAllStudents(){
	  List<Student> student=studentService.getAllStudent();
	  return ResponseEntity.ok(student); 
  }
  
 
  
}