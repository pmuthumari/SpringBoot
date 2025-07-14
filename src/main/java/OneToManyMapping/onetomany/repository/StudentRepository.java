package OneToManyMapping.onetomany.repository;

import OneToManyMapping.onetomany.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
