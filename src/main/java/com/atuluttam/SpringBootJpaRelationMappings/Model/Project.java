package com.atuluttam.SpringBootJpaRelationMappings.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    private Long PId;
    private String PName;
    @ManyToMany(mappedBy = "projects")
    private List<Student> students;
}
