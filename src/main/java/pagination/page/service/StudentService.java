package pagination.page.service;


import org.springframework.web.multipart.MultipartFile;
import pagination.page.entity.Student;

import java.util.List;

public interface StudentService {
    void importCSV(MultipartFile file);
    List<Student> getAllStudents();
}
