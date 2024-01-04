package com.example.mavenparlament.service;

import com.example.mavenparlament.domain.Kepviselo;
import com.example.mavenparlament.repository.KepviseloRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class KepviseloService {

    private final KepviseloRepository kepviseloRepository;

    @Autowired
    public KepviseloService(KepviseloRepository kepviseloRepository) {
        this.kepviseloRepository = kepviseloRepository;
    }

    public void saveKepviselo(Kepviselo kepviselo) {
        kepviseloRepository.save(kepviselo);
    }

    public List<Kepviselo> getAllKepviselok() {
        return kepviseloRepository.findAll();
    }
}
