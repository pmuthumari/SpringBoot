package pagination.page.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pagination.page.entity.Student;
import pagination.page.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/import")
    public ResponseEntity<String> uploadCSV(@RequestParam("file") MultipartFile file) {
        service.importCSV(file);
        return ResponseEntity.ok("CSV imported successfully");
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }
}

