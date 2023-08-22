package com.neo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
