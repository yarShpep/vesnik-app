package rut.miit.vesnik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rut.miit.vesnik.entity.Incident;

public interface IncidentRepository extends JpaRepository<Incident, Long> {

}
