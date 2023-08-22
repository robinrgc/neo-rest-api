package com.neo.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.demo.entity.Student;
import com.neo.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student getStudent(int i) {
		Optional<Student> optional = studentRepository.findById(i);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	@Override
	public int addStudent(Student student) {
		Student save = studentRepository.save(student);
		return save.getId();
	}

	@Override
	public void updateStudent(Student student) {
		studentRepository.save(student);
		
	}

	@Override
	public void deleteStudent(int id) {
		Optional<Student> optional = studentRepository.findById(id);
		if(!optional.isEmpty()) {
			studentRepository.delete(optional.get());
		}
	}

}
