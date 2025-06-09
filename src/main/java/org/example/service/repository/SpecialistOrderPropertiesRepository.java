package org.example.service.repository;
import org.example.service.domain.SpecialistOrderProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialistOrderPropertiesRepository  extends JpaRepository<SpecialistOrderProperties, Long> {
}
