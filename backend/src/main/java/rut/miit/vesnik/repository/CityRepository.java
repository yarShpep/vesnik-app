package rut.miit.vesnik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rut.miit.vesnik.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
