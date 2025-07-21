package page.pagination.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import page.pagination.entity.Student;
import page.pagination.service.StudentService;


@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/import")
    public String importCsv(@RequestParam("file") MultipartFile file) {
        studentService.importCsv(file);
        return "CSV data imported successfully.";
    }
    @GetMapping
    public Page<Student> getStudents(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return studentService.getAllStudents(pageable);  // ✅ This must return Page<Student>
    }


}