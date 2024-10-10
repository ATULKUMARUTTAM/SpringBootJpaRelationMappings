package com.atuluttam.SpringBootJpaRelationMappings.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private Long Aid;
    private String city;
    private String country;

   // @OneToOne
   // @JoinColumn(name="S_id")
 //   private Student student;
}
