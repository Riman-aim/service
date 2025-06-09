package org.example.service.repository;


import org.example.service.domain.CustomerOrderProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderPropertiesRepository extends JpaRepository<CustomerOrderProperties, Long> {
}
