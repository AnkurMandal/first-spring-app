package com.example.studentmanagementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public Student getStudent(int regNo){
        return studentRepository.getStudent(regNo);
    }

    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public Student getStudentByPath(int regNo) {
        return studentRepository.getStudentByPath(regNo);
    }

    public Student updateAge(int regNo, int newAge) {
        return studentRepository.updateAge(regNo,newAge);
    }

    public String deleteStudent(int regNo) {
       return studentRepository.deleteStudent(regNo);
    }

    public String deleteStudentByPath(int regNo) {
        return studentRepository.deleteStudentByPath(regNo);
    }

    public Student updateCourse(int regNo, String newCourse) {
        return studentRepository.updateCourse(regNo,newCourse);
    }

    public Student updateCourseByPath(int regNo, String newCourse) {
        return studentRepository.updateCourseByPath(regNo,newCourse);
    }

    public Student updateCourseByPathAndParam(int regNo, String newCourse) {
        return studentRepository.updateCourseByPathAndParam(regNo,newCourse);
    }
}
