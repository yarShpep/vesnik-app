package rut.miit.vesnik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rut.miit.vesnik.entity.District;

import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District, Long> {
    Optional<District> findByNameAndRegionId(String name, Long regionId);
}
