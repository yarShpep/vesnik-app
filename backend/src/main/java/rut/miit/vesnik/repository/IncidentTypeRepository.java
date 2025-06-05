package rut.miit.vesnik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rut.miit.vesnik.entity.IncidentType;

public interface IncidentTypeRepository extends JpaRepository<IncidentType, Long> {

}