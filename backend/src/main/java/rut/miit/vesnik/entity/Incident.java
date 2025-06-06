package rut.miit.vesnik.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "incident")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "incident_id")
    private Long id;

    @Column(name = "incident_date", nullable = false)
    private LocalDate incidentDate;

    @Column(name = "incident_time", nullable = false)
    private LocalTime incidentTime;

    /**
     * ManyToOne → Location (обязательно).
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Column(name = "track")
    private String track;

    @Column(name = "km_pk")
    private String kmPk;

    /**
     * ManyToOne → IncidentType (может быть NULL, если тип не занесли в справочник).
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incident_type_id")
    private IncidentType incidentType;

    /**
     * Поле, куда можно сразу вставить свободное текстовое описание типа инцидента
     * (если не захотели создавать запись в справочнике).
     */
    @Column(name = "incident_type_text")
    private String incidentTypeText;

    @Column(name = "description", columnDefinition = "text", nullable = false)
    private String description;

    /**
     * ManyToOne → Chairman (обязательно).
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chairman_id", nullable = false)
    private Chairman chairman;
}
