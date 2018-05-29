package edu.abhi.Java8.training.services;

import java.util.ArrayList;
import java.util.List;

import edu.Java8.training.pojos.Student;

public class StudentService {
	public List<Student> getAllStudents() {
		Student obj1 = new Student();
		obj1.setName("mkyong");
		obj1.addBook("Java 8 in Action");
		obj1.addBook("Spring Boot in Action");
		obj1.addBook("Effective Java (2nd Edition)");

		Student obj2 = new Student();
		obj2.setName("zilap");
		obj2.addBook("Learning Python, 5th Edition");
		obj2.addBook("Effective Java (2nd Edition)");

		List<Student> list = new ArrayList<>();
		list.add(obj1);
		list.add(obj1);
		return list;
	}

}
