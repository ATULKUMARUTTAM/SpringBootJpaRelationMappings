package com.atuluttam.SpringBootJpaRelationMappings.Repository;

import com.atuluttam.SpringBootJpaRelationMappings.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
