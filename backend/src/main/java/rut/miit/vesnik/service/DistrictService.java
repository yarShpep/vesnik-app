package rut.miit.vesnik.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rut.miit.vesnik.entity.District;
import rut.miit.vesnik.entity.Region;
import rut.miit.vesnik.repository.DistrictRepository;

@Service
@RequiredArgsConstructor
public class DistrictService {
    private final DistrictRepository districtRepository;
    private final RegionService regionService;

    public District save(District district) {
        return districtRepository.save(district);
    }

    /**
     * Найти District по имени и ID региона или создать новый.
     */
    public District findOrCreate(String districtName, String regionName) {
        // 1) Сначала убедимся, что Region существует.
        Region region = regionService.findOrCreate(regionName);

        // 2) Ищем District внутри региона
        return districtRepository.findByNameAndRegionId(districtName, region.getId())
                .orElseGet(() -> {
                    District d = new District();
                    d.setName(districtName);
                    d.setRegion(region);
                    return districtRepository.save(d);
                });
    }
}
