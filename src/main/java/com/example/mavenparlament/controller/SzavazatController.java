package com.example.mavenparlament.controller;

import com.example.mavenparlament.domain.Szavazat;
import com.example.mavenparlament.dto.SzavazatCommand;
import com.example.mavenparlament.service.SzavazatService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/szavazasok")
public class SzavazatController {
    private final SzavazatService szavazatService;

    @Autowired
    public SzavazatController(SzavazatService szavazatService) {
        this.szavazatService = szavazatService;
    }

    @PostMapping("/szavazat")
    public ResponseEntity<String> letrehozSzavazat(@RequestBody SzavazatCommand szavazatComand, HttpServletRequest request){
        try {
            Szavazat szavazat = new Szavazat();
            szavazat.setKepviselo(szavazatComand.getKepviselo());
            szavazat.setSzavazat(szavazatComand.getSzavazat());
            szavazatService.mentSzavazat(szavazat);
            System.out.println("Szavazat: "+szavazat);
            return new ResponseEntity<>("Szavazat létrehozása sikeres", HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>("Hiba történt a Szavazat létrehozása közben", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}