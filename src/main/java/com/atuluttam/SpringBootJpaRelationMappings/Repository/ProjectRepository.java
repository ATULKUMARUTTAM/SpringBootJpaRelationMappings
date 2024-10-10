package com.atuluttam.SpringBootJpaRelationMappings.Repository;

import com.atuluttam.SpringBootJpaRelationMappings.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
