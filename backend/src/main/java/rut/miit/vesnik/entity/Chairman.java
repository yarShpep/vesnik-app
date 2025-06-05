package rut.miit.vesnik.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "chairman")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chairman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chairman_id")
    private Long id;

    @Column(name = "full_name", nullable = false, unique = true)
    private String fullName;

    /**
     * OneToMany → Incident. Можно убрать, если не нужна двунаправленная связь.
     */
    @OneToMany(mappedBy = "chairman", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Incident> incidents;
}
