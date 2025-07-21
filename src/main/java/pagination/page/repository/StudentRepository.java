package pagination.page.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pagination.page.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {}
