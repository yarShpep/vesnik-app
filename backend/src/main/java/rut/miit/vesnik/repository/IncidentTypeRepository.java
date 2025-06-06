package rut.miit.vesnik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rut.miit.vesnik.entity.IncidentType;

import java.util.Optional;

public interface IncidentTypeRepository extends JpaRepository<IncidentType, Long> {
    Optional<IncidentType> findByName(String name);
}