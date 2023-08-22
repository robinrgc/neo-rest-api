package com.neo.demo.service;

import com.neo.demo.entity.Student;

public interface StudentService {

	Student getStudent(int id);

	int addStudent(Student student);

	void updateStudent(Student student);

	void deleteStudent(int id);

}
