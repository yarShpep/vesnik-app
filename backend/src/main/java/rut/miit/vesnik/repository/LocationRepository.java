package rut.miit.vesnik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rut.miit.vesnik.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}