package com.atuluttam.SpringBootJpaRelationMappings.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    private Long DId;
    private String Dname;

    @OneToMany(mappedBy = "dept")
    private List<Student> studentList;
}
