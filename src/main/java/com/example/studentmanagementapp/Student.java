package com.example.studentmanagementapp;

public class Student {
    private int regNo;
    private  String name;
    private  int age;
    private  String course;
//    private Month monthOfBirth =Month.JULY;

    public Student() {
    }

    public Student(int regNo, String name, int age, String course) {
        this.regNo = regNo;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regno) {
        this.regNo = regno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "regNo=" + regNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                '}';
    }
}
