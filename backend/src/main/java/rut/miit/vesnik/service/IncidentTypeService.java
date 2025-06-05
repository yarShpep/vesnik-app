package rut.miit.vesnik.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rut.miit.vesnik.entity.IncidentType;
import rut.miit.vesnik.repository.IncidentTypeRepository;

@Service
@RequiredArgsConstructor
public class IncidentTypeService {
    private final IncidentTypeRepository incidentTypeRepository;

    public IncidentType save(IncidentType incidentType) {
        return incidentTypeRepository.save(incidentType);
    }

    public IncidentType findOrCreate(String typeName) {
        return incidentTypeRepository.findByName(typeName)
                .orElseGet(() -> {
                    IncidentType it = new IncidentType();
                    it.setName(typeName);
                    return incidentTypeRepository.save(it);
                });
    }
}
