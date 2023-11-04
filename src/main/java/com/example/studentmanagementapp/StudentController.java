package com.example.studentmanagementapp;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    Map<Integer,Student> db=new HashMap<>();

    @GetMapping("/get")
    public Student getStudent(@RequestParam("q") int regNo){
        return db.get(regNo);
    }
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        db.put(student.getRegNo(),student);
        return "Student has been added successfully";

    }
    @GetMapping("/getByPath/{id}")
    public Student getStudentByPath(@PathVariable("id") int regNo){
        return db.get(regNo);
    }
    @PutMapping("/update-age/{id}")
    public Student updateAge(@PathVariable ("id") int regNo,@RequestParam("age") int newAge){
        db.get(regNo).setAge(newAge);
        return db.get(regNo);
    }

    //delete a student --> request param
    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("id") int regNo){
        db.remove(regNo);
        return "Delete the Student successfully";
    }

    //delete a student --> path variable
    @DeleteMapping("/deleteStudentByPath/{id}")
    public String deleteStudentByPath(@PathVariable("id") int regNo){
        db.remove(regNo);
        return "Delete the Student successfully by path varible";
    }

    //change of a student (regNo,newCourse) --> request param
    @PutMapping("/update-course")
    public Student updateCourse(@RequestParam("id") int regNo,@RequestParam("newCourse") String newCourse){
        db.get(regNo).setCourse(newCourse);
        return db.get(regNo);
    }

    //change of a student --> both as pathvarible
    @PutMapping("/updateCourseByPath/{id}/{newCourse}")
    public Student updateCourseByPath(@PathVariable("id") int regNo,@PathVariable("newCourse") String newCourse){
        db.get(regNo).setCourse(newCourse);
        return db.get(regNo);
    }
    //change course --> one as request param,one as path variable
    @PutMapping("/updateCourseByPathAndParam/{id}")
    public Student updateCourseByPathAndParam(@PathVariable("id") int regNo,@RequestParam("newCourse") String newCourse){
        db.get(regNo).setCourse(newCourse);
        return db.get(regNo);
    }

    //change course and age -->regNo as request param,entire student object as request body
    public Student updateCourseAndAge(int regNo,Student student){
        return db.get(regNo);
    }


}
