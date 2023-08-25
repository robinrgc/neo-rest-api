package com.neo.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neo.demo.entity.Student;
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {

//	@Query(value = "SELECT * FROM student",nativeQuery = true)
	@Query("SELECT s FROM Student s")
	List<Student> findStudents();
	
//	@Query("Select s From Student s Where s.id = ?1")
	@Query("Select s From Student s Where s.id = :id")
	Student findStudent(@Param("id") int id);
	
	
	@Modifying
	@Query("UPDATE Student SET name = :name WHERE id = :id")
	void updateStudentName(@Param("id") int id,@Param("name") String name);

	@Modifying
	@Query("DELETE Student s WHERE s.id = :id")
	void deleteStudent(@Param("id") int id);
	
	
}
