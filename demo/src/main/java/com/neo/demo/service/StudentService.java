package com.neo.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.neo.demo.entity.Student;

public interface StudentService {

	Student getStudent(int id);

	int addStudent(Student student);

	void updateStudent(Student student);

	void deleteStudent(int id);

	List<Student> getAllStudents();

	Page<Student> getAllStudentsWithPagination(int page, int size);

	Page<Student> getAllStudentsWithPaginationAndSorting(int page, int size, String field);

}
