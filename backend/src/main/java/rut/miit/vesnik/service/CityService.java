package rut.miit.vesnik.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rut.miit.vesnik.entity.City;
import rut.miit.vesnik.entity.District;
import rut.miit.vesnik.repository.CityRepository;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final DistrictService districtService;

    public City save(City city) {
        return cityRepository.save(city);
    }

    /**
     * Найти City по имени, District + Region (имена) или создать новый City.
     */
    public City findOrCreate(String cityName, String districtName, String regionName) {
        // 1) Гарантируем, что District (а значит и Region) уже есть
        District district = districtService.findOrCreate(districtName, regionName);

        // 2) Ищем просто по (cityName, districtId)
        return cityRepository.findByNameAndDistrictId(cityName, district.getId())
                .orElseGet(() -> {
                    City c = new City();
                    c.setName(cityName);
                    c.setDistrict(district);
                    return cityRepository.save(c);
                });
    }

}
