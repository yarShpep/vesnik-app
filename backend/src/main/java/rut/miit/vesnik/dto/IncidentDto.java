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
public class IncidentDto {
    private Long id; // можно не использовать для создания, но оставлено для совместимости
    private LocalDate date;       // в формате "yyyy-MM-dd"
    private LocalTime time;       // в формате "HH:mm"
    private String location;      // например, "станция Тверь" или "перегон Клин — Решетниково"
    private String track;
    private String km_pk;
    private String incident_type; // например, "сход подвижного состава"
    private String description;
    private String chairman;      // например, "Иванов И.И."
    private String region;        // например, "Московская область"
    private String district;      // например, "Клинский район"
    private String city;          // например, "Клин"
}
