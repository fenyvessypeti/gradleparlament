package com.example.mavenparlament.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "szavazat")
public class Szavazat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "szavazat_id")
    public Long id;

    @Column(name="kepviselo_id")
    private String kepviselo;

    @Column(name="szavazat")
    private String  szavazat;

    @ManyToOne
    @JoinColumn(name = "szavazas_id")
    private Szavazas szavazas;

    public Szavazat(String kepviselo, String szavazat, Szavazas szavazas) {
        this.kepviselo = kepviselo;
        this.szavazat = szavazat;
        this.szavazas = szavazas;
    }
}