package com.example.mavenparlament.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="szavazas")
public class Szavazas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "szavazas_id")
    private Long id;

    private String idopont;
    private String targy;
    private String tipus;
    private String elnok;

    @OneToMany(mappedBy = "szavazas")
    private List<Szavazat> szavazatok = new ArrayList<>();

}
