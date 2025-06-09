package org.example.service.repository;


import org.example.service.domain.UnderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnderServiceRepository extends JpaRepository<UnderService, Integer> {
    boolean existsByName(String name);
}
