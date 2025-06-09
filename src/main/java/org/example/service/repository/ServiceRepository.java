package org.example.service.repository;


import org.example.service.domain.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
    boolean existsServiceByName(String name);

    boolean existsByName(String name);
}
