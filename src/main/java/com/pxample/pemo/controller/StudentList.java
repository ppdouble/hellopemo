package com.pxample.pemo.controller;

import com.pxample.pemo.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class StudentList {
/*
    @RequestMapping("/StudentList")
    @ResponseBody // when you just want to render json
    public List studentlist(Model model) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student(1, "Tom", 80.5));
        studentList.add(new Student(2, "Jerry", 90.4));
        studentList.add(new Student(3, "Paul", 77.5));

        return studentList;
    }

 */
    @RequestMapping("/liststudents")
    public String studentlist(Model model) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student(1, "Tom", 80.5));
        studentList.add(new Student(2, "Jerry", 90.4));
        studentList.add(new Student(3, "Paul", 77.5));

        Map<String, Object> mydataMap = new HashMap<>();
        LocalDate localDate = LocalDate.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String formattedDateString = localDate.format(formatter);
        //mydata.put(formattedDateString, "hello");
        mydataMap.put("Message", "hello");
        mydataMap.put("Date", formattedDateString);


        model.addAttribute("slist", studentList); // the attrbuteName should same with the corresponding variable the template file
        model.addAttribute("mydata", mydataMap);
        return "studentlist"; // same with the template file name
    }
}



