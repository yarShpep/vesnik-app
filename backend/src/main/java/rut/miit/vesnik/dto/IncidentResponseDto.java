package rut.miit.vesnik.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IncidentResponseDto {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private String location;
    private String track;
    private String kmPk;
    private String incidentType;
    private String description;
    private String chairman;
    private String region;
    private String district;
    private String city;
}
