package rut.miit.vesnik.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rut.miit.vesnik.dto.IncidentDto;
import rut.miit.vesnik.dto.IncidentResponseDto;
import rut.miit.vesnik.entity.Incident;
import rut.miit.vesnik.service.IncidentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/incidents")
@RequiredArgsConstructor
public class IncidentController {
    private final IncidentService incidentService;

    /**
     * POST /incidents
     * Cоздает инцидент.
     */
    @PostMapping
    public ResponseEntity<Void> createIncident(@RequestBody IncidentDto dto) {
        incidentService.createFromDto(dto);
        return ResponseEntity.ok().build();
    }

    /**
     * GET /incidents
     * Возвращает список всех инцидентов.
     */
    @GetMapping
    public ResponseEntity<List<IncidentResponseDto>> getAllIncidents() {
        List<Incident> incidents = incidentService.findAll();

        List<IncidentResponseDto> response = incidents.stream()
                .map(this::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    /**
     * Преобразует сущность Incident в IncidentResponseDto.
     */
    private IncidentResponseDto toDto(Incident inc) {
        String regionName = inc.getLocation()
                .getCity()
                .getDistrict()
                .getRegion()
                .getName();

        String districtName = inc.getLocation()
                .getCity()
                .getDistrict()
                .getName();

        String cityName = inc.getLocation()
                .getCity()
                .getName();

        String locationName = inc.getLocation().getName();
        String incidentTypeName = inc.getIncidentType() != null
                ? inc.getIncidentType().getName()
                : inc.getIncidentTypeText();

        String chairmanName = inc.getChairman().getFullName();

        return new IncidentResponseDto(
                inc.getId(),
                inc.getIncidentDate(),
                inc.getIncidentTime(),
                locationName,
                inc.getTrack(),
                inc.getKmPk(),
                incidentTypeName,
                inc.getDescription(),
                chairmanName,
                regionName,
                districtName,
                cityName
        );
    }
}
