package com.atuluttam.SpringBootJpaRelationMappings.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private Long sid;
    private String sname;
    @Enumerated(EnumType.STRING)
    private StudentType type;

    @OneToOne
    @JoinColumn(name="address_id", referencedColumnName = "Aid")
    private Address address;

    @ManyToOne
    @JoinColumn(name="D_Id")
    private Department dept;

    @ManyToMany
    @JoinTable(
            name="student_project",
            joinColumns = @JoinColumn(name="S_id"),
            inverseJoinColumns = @JoinColumn(name="P_id")
    )
    private List<Project> projects;
}
