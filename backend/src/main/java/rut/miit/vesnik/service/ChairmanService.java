package rut.miit.vesnik.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rut.miit.vesnik.entity.Chairman;
import rut.miit.vesnik.repository.ChairmanRepository;

@Service
@RequiredArgsConstructor
public class ChairmanService {
    private final ChairmanRepository chairmanRepository;

    public Chairman save(Chairman chairman) {
        return chairmanRepository.save(chairman);
    }

    public Chairman findOrCreate(String fullName) {
        return chairmanRepository.findByFullName(fullName)
                .orElseGet(() -> {
                    Chairman ch = new Chairman();
                    ch.setFullName(fullName);
                    return chairmanRepository.save(ch);
                });
    }
}
