package OneToManyMapping.onetomany.repository;

import OneToManyMapping.onetomany.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

