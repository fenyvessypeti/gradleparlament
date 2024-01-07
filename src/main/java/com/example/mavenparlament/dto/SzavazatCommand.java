package com.example.mavenparlament.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SzavazatCommand {
    private String kepviselo;
    private String szavazat;
}