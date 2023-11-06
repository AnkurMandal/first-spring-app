package com.example.studentmanagementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

//    @Autowired
//    StudentRepository studentRepository;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        System.out.println("Service bean called in Controller: "+studentService);
        return studentService.addStudent(student);


    }

    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("q") int regNo){
        System.out.println("Service bean called in Controller: "+studentService);
        Student student=studentService.getStudent(regNo);
        if(student==null){
            return new ResponseEntity<>("Id doesn't exist",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(student,HttpStatus.FOUND);
    }
    @GetMapping("/getByPath/{id}")
    public ResponseEntity getStudentByPath(@PathVariable("id") int regNo){
        Student student=studentService.getStudentByPath(regNo);
        if(student==null){
            return new ResponseEntity<>("Id doesn't exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student,HttpStatus.FOUND);

    }
    @PutMapping("/update-age/{id}")
    public ResponseEntity updateAge(@PathVariable ("id") int regNo,@RequestParam("age") int newAge){
        Student student= studentService.updateAge(regNo,newAge);
        if(student==null){
            return new ResponseEntity<>("Id doesn't exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student,HttpStatus.FOUND);

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
    public ResponseEntity updateCourse(@RequestParam("id") int regNo,@RequestParam("newCourse") String newCourse){
        Student student= studentService.updateCourse(regNo,newCourse);
        if(student==null){
            return new ResponseEntity<>("Id doesn't exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student,HttpStatus.FOUND);
    }

    //change of a student --> both as pathvarible
    @PutMapping("/updateCourseByPath/{id}/{newCourse}")
    public ResponseEntity updateCourseByPath(@PathVariable("id") int regNo,@PathVariable("newCourse") String newCourse){
        Student student= studentService.updateCourseByPath(regNo,newCourse);
        if(student==null){
            return new ResponseEntity<>("Id doesn't exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student,HttpStatus.FOUND);

    }
    //change course --> one as request param,one as path variable
    @PutMapping("/updateCourseByPathAndParam/{id}")
    public ResponseEntity updateCourseByPathAndParam(@PathVariable("id") int regNo,@RequestParam("newCourse") String newCourse){
        Student student= studentService.updateCourseByPathAndParam(regNo,newCourse);
        if(student==null){
            return new ResponseEntity<>("Id doesn't exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student,HttpStatus.FOUND);

    }

    //change course and age -->regNo as request param,entire student object as request body
//    public Student updateCourseAndAge(int regNo,Student student){
//
//        return db.get(regNo);
//    }


}
