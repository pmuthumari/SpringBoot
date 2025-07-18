package com.example.demo.service;

import com.example.demo.entity.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {
    void saveCSV(MultipartFile file);
    List<Student> getAllStudents();
}
