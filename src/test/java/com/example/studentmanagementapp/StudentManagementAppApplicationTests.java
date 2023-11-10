package com.example.studentmanagementapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentManagementAppApplicationTests {

	@Autowired
	StudentService studentService;

	@BeforeEach
	public void prepareDb(){
		studentService.addStudent(new Student(1,"dummy1",24,"CS"));
		studentService.addStudent(new Student(2,"dummy2",24,"IT"));
		studentService.addStudent(new Student(3,"dummy3",24,"Entc"));

	}
	@Test
	public void addStudentTest(){
		Student student=new Student(1,"dummy",24,"Entc");
		studentService.addStudent(student);

		Student expectedOutput=new Student(1,"dummy",24,"Entc");
		Student actualOutput=studentService.getStudent(1);

		Assertions.assertEquals(expectedOutput.getRegNo(),actualOutput.getRegNo());
		Assertions.assertEquals(expectedOutput.getName(),actualOutput.getName());
		Assertions.assertEquals(expectedOutput.getAge(),actualOutput.getAge());
		Assertions.assertEquals(expectedOutput.getCourse(),actualOutput.getCourse());

	}

	@Test
	public void getStudentTest(){
		Student expectedOutput=new Student(2,"dummy2",24,"IT");
		Student actualOutput=studentService.getStudent(2);

		Assertions.assertEquals(expectedOutput.getRegNo(),actualOutput.getRegNo());
		Assertions.assertEquals(expectedOutput.getName(),actualOutput.getName());
		Assertions.assertEquals(expectedOutput.getAge(),actualOutput.getAge());
		Assertions.assertEquals(expectedOutput.getCourse(),actualOutput.getCourse());
	}

	@Test
	void contextLoads() {
	}

}
