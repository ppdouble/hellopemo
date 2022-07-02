package com.pxample.pemo.pojo;

public class Student {
    private Integer Id;
    private String studentName;
    private double grade;

    public Student(Integer Id, String studentName, double grade) {
        this.Id = Id;
        this.studentName = studentName;
        this.grade = grade;
    }

    public Integer getId() {
        return this.Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
