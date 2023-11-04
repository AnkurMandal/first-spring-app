package com.example.studentmanagementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;
    @GetMapping("/get")
    public Student getStudent(@RequestParam("q") int regNo){
        return studentService.getStudent(regNo);
    }
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);


    }
    @GetMapping("/getByPath/{id}")
    public Student getStudentByPath(@PathVariable("id") int regNo){
        return studentService.getStudentByPath(regNo);

    }
    @PutMapping("/update-age/{id}")
    public Student updateAge(@PathVariable ("id") int regNo,@RequestParam("age") int newAge){
        return studentService.updateAge(regNo,newAge);

    }

    //delete a student --> request param
    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("id") int regNo){
        return studentService.deleteStudent(regNo);

    }

    //delete a student --> path variable
    @DeleteMapping("/deleteStudentByPath/{id}")
    public String deleteStudentByPath(@PathVariable("id") int regNo){
        return studentService.deleteStudentByPath(regNo);

    }

    //change of a student (regNo,newCourse) --> request param
    @PutMapping("/update-course")
    public Student updateCourse(@RequestParam("id") int regNo,@RequestParam("newCourse") String newCourse){
        return studentService.updateCourse(regNo,newCourse);
    }

    //change of a student --> both as pathvarible
    @PutMapping("/updateCourseByPath/{id}/{newCourse}")
    public Student updateCourseByPath(@PathVariable("id") int regNo,@PathVariable("newCourse") String newCourse){
        return studentService.updateCourseByPath(regNo,newCourse);

    }
    //change course --> one as request param,one as path variable
    @PutMapping("/updateCourseByPathAndParam/{id}")
    public Student updateCourseByPathAndParam(@PathVariable("id") int regNo,@RequestParam("newCourse") String newCourse){
        return studentService.updateCourseByPathAndParam(regNo,newCourse);

    }

    //change course and age -->regNo as request param,entire student object as request body
//    public Student updateCourseAndAge(int regNo,Student student){
//
//        return db.get(regNo);
//    }


}
