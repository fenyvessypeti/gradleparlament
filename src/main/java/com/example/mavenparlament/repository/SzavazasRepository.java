package com.example.mavenparlament.repository;

import com.example.mavenparlament.domain.Szavazas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SzavazasRepository extends JpaRepository<Szavazas, Long> {
}