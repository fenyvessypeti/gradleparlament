package com.example.mavenparlament.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "kepviselo")
public class Kepviselo {
    @Id
    @Column(name = "kepviselo_id")
    private String kepviseloId;

    @Column(name = "kepviselo_nev")
    private String kepviseloNev;

}
