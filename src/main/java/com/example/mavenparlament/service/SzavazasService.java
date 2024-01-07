package com.example.mavenparlament.service;

import com.example.mavenparlament.domain.Szavazas;
import com.example.mavenparlament.domain.Szavazat;
import com.example.mavenparlament.dto.SzavazasCommand;
import com.example.mavenparlament.dto.SzavazatCommand;
import com.example.mavenparlament.repository.SzavazasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SzavazasService {
    private final SzavazasRepository szavazasRepository;
    private final SzavazatService szavazatService;

    @Autowired
    public SzavazasService(SzavazasRepository szavazasRepository, SzavazatService szavazatService) {
        this.szavazasRepository = szavazasRepository;
        this.szavazatService = szavazatService;
    }

    public void mentSzavazas(SzavazasCommand szavazasCommand) {
        Szavazas szavazas = new Szavazas();
        szavazas.setIdopont(szavazasCommand.getIdopont());
        szavazas.setTargy(szavazasCommand.getTargy());
        szavazas.setTipus(szavazasCommand.getTipus());
        szavazas.setElnok(szavazasCommand.getElnok());
        if (szavazasEllenorzes(szavazasCommand)) {
            szavazasRepository.save(szavazas);

            for (SzavazatCommand szavazatCommand : szavazasCommand.getSzavazatok()) {
                Szavazat szavazat = new Szavazat();
                szavazat.setKepviselo(szavazatCommand.getKepviselo());
                szavazat.setSzavazat(szavazatCommand.getSzavazat());
                Szavazat mentettSzavazat = szavazatService.mentSzavazat(szavazat);
                szavazat.setSzavazas(szavazas);
            }
        }
    }

    private boolean szavazasEllenorzes(SzavazasCommand szavazasCommand) {
        boolean isSikeres = (isElnokSzavazott(szavazasCommand)&&isMegfeleloStrukturaju(szavazasCommand));
        return isSikeres;
    }

    private boolean isElnokSzavazott(SzavazasCommand szavazasCommand) {
        return szavazasCommand.getElnok() != null;
    }

    private boolean isMegfeleloStrukturaju(SzavazasCommand szavazasCommand) {
        return (szavazasCommand.getIdopont() != null && szavazasCommand.getTargy() != null &&
                szavazasCommand.getTipus() != null);
    }

}
