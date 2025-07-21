package pagination.page.service;


import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pagination.page.entity.Student;
import pagination.page.repository.StudentRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public void importCSV(MultipartFile file) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
                CSVReader csvReader = new CSVReader(reader)
        ) {
            String[] line;
            boolean isFirstLine = true;
            List<Student> students = new ArrayList<>();

            while ((line = csvReader.readNext()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // skip header
                }

                Student student = new Student();
                student.setId(Long.parseLong(line[0]));
                student.setName(line[1]);
                student.setEmail(line[2]);

                students.add(student);
            }

            repository.saveAll(students);
        } catch (Exception e) {
            throw new RuntimeException("CSV import failed: " + e.getMessage());
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }
}
