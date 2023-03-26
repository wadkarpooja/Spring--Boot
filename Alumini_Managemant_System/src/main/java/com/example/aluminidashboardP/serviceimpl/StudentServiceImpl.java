package com.example.aluminidashboardP.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aluminidashboardP.entity.Student;
import com.example.aluminidashboardP.exception.UserNotFoundException;
import com.example.aluminidashboardP.repository.StudentRepository;
import com.example.aluminidashboardP.service.StudentService;
import com.example.aluminidashboardP.studentDTO.StudentDTO;

@Service
public class StudentServiceImpl implements StudentService {
 
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student createStudent(StudentDTO studentDTO) {
		Student student=Student.builder().name(studentDTO.getName()).email(studentDTO.getEmail()).phone(studentDTO.getPhone()).grdYear(studentDTO.getGrdYear()).build();
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(int id, StudentDTO studentDTO) throws UserNotFoundException
	{
		Optional <Student> adata = studentRepository.findById(id);
		if(adata.isEmpty())
		{
			Student _student=studentRepository.findById(id).get();
			_student.setName(studentDTO.getName());
			_student.setPhone(studentDTO.getPhone());
			_student.setEmail(studentDTO.getEmail());
			_student.setGrdYear(studentDTO.getGrdYear());
			
			return studentRepository.save(_student);
		}
		
	else throw new UserNotFoundException("No user bearing id"+id+"can be found");
	}

	@Override
	public Student getAllStudentById(int id) 
	{
		return studentRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No User bearing id "+id+" can be found"));
	}

	@Override
	public List<Student> findByNameContaining(String name) throws UserNotFoundException
	{
		if(studentRepository.findByNameContaining(name).isEmpty())
			throw new UserNotFoundException("No User bearing id "+name+" can be found");
		else
		return studentRepository.findByNameContaining(name);
	}

	@Override
	public List<Student> findByGrdYearContaining(String grdYear) {
		if(studentRepository.findBygrdYearContaining(grdYear).isEmpty())
			throw new UserNotFoundException("No student with graduation "+grdYear+" can be found");
		else
		return studentRepository.findBygrdYearContaining(grdYear);
	}

	@Override
	public String deleteStudent(int id) 
	{
		studentRepository.deleteById(id);
		return "Student bearing id "+id+" has been deleted successfully.....!";
	}

	
}
