package com.example.pgf.repository;

import com.example.pgf.entity.Pg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PgRepository extends JpaRepository<Pg, Long> {

    List<Pg> findByCity(String city);

    List<Pg> findByPgNameContainingIgnoreCase(String pgName);

}