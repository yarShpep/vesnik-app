package rut.miit.vesnik.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "incident_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncidentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "incident_type_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    /**
     * OneToMany → Incident. Можно убрать, если не нужна двунаправленная связь.
     */
    @OneToMany(mappedBy = "incidentType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Incident> incidents;
}
