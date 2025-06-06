package rut.miit.vesnik.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rut.miit.vesnik.entity.City;
import rut.miit.vesnik.entity.Location;
import rut.miit.vesnik.repository.LocationRepository;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;
    private final CityService cityService;

    public Location save(Location location){
        return locationRepository.save(location);
    }

    /**
     * Найти Location по имени или создать новый, указывая, к какому City (→ District → Region) она относится.
     */
    public Location findOrCreate(String locationName,
                                 String cityName,
                                 String districtName,
                                 String regionName) {
        // 1) Сначала найдём/создадим City (сам его метод найдёт/создаст District+Region при необходимости):
        City city = cityService.findOrCreate(cityName, districtName, regionName);

        // 2) Ищем уже имеющуюся Location по полю name
        return locationRepository.findByName(locationName)
                .orElseGet(() -> {
                    // Если не нашли — создаём новую
                    Location loc = new Location();
                    loc.setName(locationName);

                    // Примерно определяем тип локации:
                    String lower = locationName.toLowerCase();
                    if (lower.startsWith("станция")) {
                        loc.setLocationType("станция");
                    } else if (lower.startsWith("перегон")) {
                        loc.setLocationType("перегон");
                    } else {
                        loc.setLocationType("другое");
                    }
                    loc.setCity(city);
                    return locationRepository.save(loc);
                });
    }
}
