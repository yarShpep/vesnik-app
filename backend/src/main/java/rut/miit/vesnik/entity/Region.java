package rut.miit.vesnik.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "region")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Связь OneToMany с таблицей district.
     * Если не нужна двунаправленная связь, можно убрать это поле и аннотации к нему.
     */
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<District> districts;
}
