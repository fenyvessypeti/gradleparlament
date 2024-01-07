package com.example.mavenparlament.repository;

import com.example.mavenparlament.domain.Szavazat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SzavazatRepository extends JpaRepository<Szavazat, Long> {
}