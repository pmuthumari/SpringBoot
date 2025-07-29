package com.example.AAA.Controller;

import com.example.AAA.Entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        return List.of(
                new Student(1, "Arun"),
                new Student(2, "Divya"),
                new Student(3, "Kumar")
        );
    }
}
