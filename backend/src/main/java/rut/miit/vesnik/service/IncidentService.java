package rut.miit.vesnik.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rut.miit.vesnik.dto.IncidentDto;
import rut.miit.vesnik.entity.Chairman;
import rut.miit.vesnik.entity.Incident;
import rut.miit.vesnik.entity.IncidentType;
import rut.miit.vesnik.entity.Location;
import rut.miit.vesnik.repository.IncidentRepository;

import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentService {
    private final IncidentRepository incidentRepository;
    private final IncidentTypeService incidentTypeService;
    private final ChairmanService chairmanService;
    private final LocationService locationService;

    public Incident save(Incident incident) {
        return incidentRepository.save(incident);
    }

    /**
     * Основной метод: принимает DTO, находит/создаёт все зависимые сущности и сохраняет Incident.
     */
    @Transactional
    public void createFromDto(IncidentDto dto) {
        // 1) IncidentType
        IncidentType incidentType = incidentTypeService.findOrCreate(dto.getIncident_type());

        // 2) Chairman
        Chairman chairman = chairmanService.findOrCreate(dto.getChairman());

        // 3) Location (он внутри себя найдёт/создаст City→District→Region)
        Location location = locationService.findOrCreate(
                dto.getLocation(),
                dto.getCity(),
                dto.getDistrict(),
                dto.getRegion()
        );

        // 4) Собираем объект Incident
        Incident incident = new Incident();
        incident.setIncidentDate(dto.getDate());
        incident.setIncidentTime(dto.getTime());

        incident.setLocation(location);
        incident.setTrack(dto.getTrack());
        incident.setKmPk(dto.getKm_pk());

        incident.setIncidentType(incidentType);

        incident.setDescription(dto.getDescription());
        incident.setChairman(chairman);

        // 5) Сохраняем сам Incident
        incidentRepository.save(incident);
    }

    /**
     * Возвращает весь список Incident из БД.
     */
    public List<Incident> findAll() {
        return incidentRepository.findAll();
    }
}
