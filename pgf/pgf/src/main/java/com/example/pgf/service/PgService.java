package com.example.pgf.service;

import com.example.pgf.dto.PgDto;

import java.util.List;

public interface PgService {

    PgDto savePg(PgDto pgDto);

    PgDto updatePg(Long id, PgDto pgDto);

    PgDto getPgById(Long id);

    List<PgDto> getAllPg();

    void deletePg(Long id);

}