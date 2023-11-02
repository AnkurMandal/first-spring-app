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
        db.put(student.getRegno(),student);
        return "Student has been added successfully";

    }
    @GetMapping("/getByPath/{id}")
    public Student getStudentByPath(@PathVariable("id") int regNo){
        return db.get(regNo);
    }
    @PutMapping("/update-age/{id}")
    public Student updateAge(@PathVariable ("id") int regno,@RequestParam("age") int newAge){
        db.get(regno).setAge(newAge);
        return db.get(regno);
    }

    //delete a student --> request param

    //delete a student --> path variable

    //change of a student (regno,newCourse) --> request param

    //change of a student --> both as pathvarible

    //change course --> one as request param,one as path varible

    //change course and age -->regno as request param,entire student object as request body
}
