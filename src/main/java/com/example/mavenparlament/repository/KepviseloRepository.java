package com.example.mavenparlament.repository;

import com.example.mavenparlament.domain.Kepviselo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KepviseloRepository extends JpaRepository<Kepviselo, String> {

}
