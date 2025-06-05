package rut.miit.vesnik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rut.miit.vesnik.entity.Chairman;

import java.util.Optional;

public interface ChairmanRepository extends JpaRepository<Chairman, Long> {
    Optional<Chairman> findByFullName(String fullName);
}