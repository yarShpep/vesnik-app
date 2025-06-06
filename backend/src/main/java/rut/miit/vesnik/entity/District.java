package rut.miit.vesnik.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "district",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"region_id", "name"})}
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    /**
     * ManyToOne → Region.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    /**
     * Связь OneToMany с таблицей city (можно убрать, если нужна только односторонняя связь).
     */
    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities;
}