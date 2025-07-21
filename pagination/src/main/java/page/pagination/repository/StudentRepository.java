package page.pagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import page.pagination.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

