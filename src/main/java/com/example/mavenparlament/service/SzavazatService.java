package com.example.mavenparlament.service;

import com.example.mavenparlament.domain.Szavazat;
import com.example.mavenparlament.repository.SzavazatRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SzavazatService {
    private final SzavazatRepository szavazatRepository;

    @Autowired
    public SzavazatService(SzavazatRepository szavazatRepository) {
        this.szavazatRepository = szavazatRepository;
    }

    public Szavazat mentSzavazat(Szavazat szavazat) {
        System.out.println("Szavazatunk: "+szavazat);
        return szavazatRepository.save(szavazat);
    }

}
