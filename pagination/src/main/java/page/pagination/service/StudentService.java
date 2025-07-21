package page.pagination.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import page.pagination.entity.Student;
import page.pagination.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Method to import CSV data into the database
    public void importCsv(MultipartFile file) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming CSV format: id,name,email (you can adjust based on your CSV)
                String[] data = line.split(",");
                if (data.length >= 2) {
                    Student student = new Student();
                    student.setName(data[0].trim());
                    student.setEmail(data[1].trim());
                    studentRepository.save(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get paginated student data
    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
}


