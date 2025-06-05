package rut.miit.vesnik.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "city",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"district_id", "name"})}
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    /**
     * ManyToOne → District.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

    /**
     * OneToMany → Location. Если связь не нужна в обе стороны, можно убрать это поле и аннотации.
     */
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Location> locations;
}
