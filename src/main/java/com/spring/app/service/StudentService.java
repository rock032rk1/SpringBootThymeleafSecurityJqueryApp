package com.spring.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.app.model.Student;
import com.spring.app.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public List<Student> getAll() {

		return (List<Student>) studentRepository.findAll();
	}

	public Optional<Student> getOne(int id) {

		return studentRepository.findById(id);
	}

	public void addNew(Student stu) {

		stu.setPassword(bCryptPasswordEncoder.encode(stu.getPassword()));
		studentRepository.save(stu);
	}

	public void update(Student stu) {
		studentRepository.save(stu);
	}

	public void delete(int id) {

		studentRepository.deleteById(id);
	}
	

}
