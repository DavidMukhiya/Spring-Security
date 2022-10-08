package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS= Arrays.asList(
      new Student(1, "James Bond"),
      new Student(2, "Maria Jones"),
      new Student(3, "Anna Smith")
    );

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        System.out.println("getStudent");
        return STUDENTS.stream()
                .filter((stu)->studentId.equals(stu.getStudentId())).findFirst()
                .orElseThrow(()->new RuntimeException("Student "+ studentId+" does not exists"));

    }
}
