package com.example.studentmanagementapp;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer,Student> db=new HashMap<>();

    public Student getStudent(int regNo){
        return db.get(regNo);
    }

    public String addStudent(Student student) {
        db.put(student.getRegNo(),student);
        return "Student has been added successfully";
    }

    public Student getStudentByPath(int regNo) {
        return db.get(regNo);
    }

    public Student updateAge(int regNo, int newAge) {
        db.get(regNo).setAge(newAge);
        return db.get(regNo);
    }

    public String deleteStudent(int regNo) {
        db.remove(regNo);
        return "Delete the Student successfully";
    }

    public String deleteStudentByPath(int regNo) {
        db.remove(regNo);
        return "Delete the Student successfully by path variable";
    }

    public Student updateCourse(int regNo, String newCourse) {
        db.get(regNo).setCourse(newCourse);
        return db.get(regNo);
    }

    public Student updateCourseByPath(int regNo, String newCourse) {
        db.get(regNo).setCourse(newCourse);
        return db.get(regNo);
    }

    public Student updateCourseByPathAndParam(int regNo, String newCourse) {
        db.get(regNo).setCourse(newCourse);
        return db.get(regNo);
    }
}
