package rut.miit.vesnik.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "location",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Поле, куда люди могут вписывать вручную «станция», «перегон» и т.д.
     */
    @Column(name = "location_type", nullable = false)
    private String locationType;

    /**
     * ManyToOne → City. Поле может быть Nullable (в случае, если перегон не привязан к конкретному городу).
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    /**
     * OneToMany → Incident. Если связь не нужна в обе стороны, можно удалить.
     */
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Incident> incidents;
}
