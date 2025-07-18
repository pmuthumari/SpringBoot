package com.example.demo.service;


import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public void saveCSV(MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
             CSVReader csvReader = new CSVReader(reader)) {

            String[] line;
            boolean isFirstLine = true;
            while ((line = csvReader.readNext()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                Student student = new Student();
                student.setName(line[0]);
                student.setEmail(line[1]);
                student.setDepartment(line[2]);

                repository.save(student);
            }
        } catch (Exception e) {
            throw new RuntimeException("CSV parsing failed: " + e.getMessage());
        }
    }

    // ✅ This was missing - must implement it
    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }
}

