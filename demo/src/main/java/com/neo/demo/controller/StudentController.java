package com.neo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.neo.demo.entity.Student;
import com.neo.demo.service.StudentService;

@RequestMapping("/student")
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable int id) {
		Student student = studentService.getStudent(id);
		if (student == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students = studentService.getAllStudents();
		return ResponseEntity.status(HttpStatus.OK).body(students);
	}
	
	@GetMapping("/page")
	public ResponseEntity<List<Student>> getAllStudentsWithPagination(@RequestParam int page,@RequestParam int size){
		Page<Student> allStudentsWithPagination = studentService.getAllStudentsWithPagination(page, size);
		return ResponseEntity.status(HttpStatus.OK).body(allStudentsWithPagination.getContent());
		
	}
	@GetMapping("/sort")
	public ResponseEntity<List<Student>> getAllStudentsWithPaginationAndSorting(@RequestParam int page,@RequestParam int size,@RequestParam String field){
		Page<Student> studentsWithPagination = studentService.getAllStudentsWithPaginationAndSorting(page,size,field);
		
		return ResponseEntity.status(HttpStatus.OK).body(studentsWithPagination.getContent());
		
	}
	
	@PostMapping
	public ResponseEntity<Integer> addStudent(@RequestBody Student student) {
		int id = studentService.addStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(id);
	}

	@PutMapping
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
		return ResponseEntity.ok(null);
	}

	@DeleteMapping
	public ResponseEntity<String> deleteStudent(@RequestBody Student student) {
		studentService.deleteStudent(student.getId());
		return ResponseEntity.ok("Deleted !");
	}

}
