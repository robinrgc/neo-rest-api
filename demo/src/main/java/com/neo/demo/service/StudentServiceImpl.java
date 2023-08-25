package com.neo.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.neo.demo.entity.Student;
import com.neo.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student getStudent(int id) {
//		Optional<Student> optional = studentRepository.findById(id);
//		if(optional.isEmpty()) {
//			return null;
//		}
//		return optional.get();
		return studentRepository.findStudent(id);
	}

	@Override
	public int addStudent(Student student) {
		if(student.getPassword().equals(student.getRePassword())) {
		Student save = studentRepository.save(student);
		return save.getId();
		}
		return 0;
	}

	@Override
	public void updateStudent(Student student) {
//		studentRepository.save(student);
		studentRepository.updateStudentName(student.getId(), student.getName());
		
	}

	@Override
	public void deleteStudent(int id) {
//		Optional<Student> optional = studentRepository.findById(id);
//		if(!optional.isEmpty()) {
//			studentRepository.delete(optional.get());
//		}
		studentRepository.deleteStudent(id);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findStudents();
	}

	@Override
	public Page<Student> getAllStudentsWithPagination(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return studentRepository.findAll(pageable);
	}

	@Override
	public Page<Student> getAllStudentsWithPaginationAndSorting(int page, int size, String field) {
		Pageable pageable = PageRequest.of(page, size,Sort.by(field));
		return studentRepository.findAll(pageable);
	}

}
