package rut.miit.vesnik.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rut.miit.vesnik.entity.Region;
import rut.miit.vesnik.repository.RegionRepository;

@Service
@AllArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;

    public Region save(Region region){
        return regionRepository.save(region);
    }

    /**
     * Сохранить новую Region (если нужно) или вернуть существующую по имени.
     */
    public Region findOrCreate(String regionName) {
        return regionRepository.findByName(regionName)
                .orElseGet(() -> {
                    Region r = new Region();
                    r.setName(regionName);
                    return regionRepository.save(r);
                });
    }
}
