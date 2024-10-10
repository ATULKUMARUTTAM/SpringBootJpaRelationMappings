package com.atuluttam.SpringBootJpaRelationMappings.Repository;

import com.atuluttam.SpringBootJpaRelationMappings.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
