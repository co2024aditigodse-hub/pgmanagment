package com.example.pgf.service.service.impl;

import com.example.pgf.dto.PgDto;
import com.example.pgf.entity.Pg;
import com.example.pgf.repository.PgRepository;
import com.example.pgf.service.PgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PgServiceImpl implements PgService {

    @Autowired
    private PgRepository pgRepository;

    @Override
    public PgDto savePg(PgDto pgDto) {

        Pg pg = new Pg();

        pg.setPgName(pgDto.getPgName());
        pg.setOwnerName(pgDto.getOwnerName());
        pg.setCity(pgDto.getCity());
        pg.setTotalRooms(pgDto.getTotalRooms());
        pg.setAvailableRooms(pgDto.getAvailableRooms());

        Pg savedPg = pgRepository.save(pg);

        return convertToDto(savedPg);
    }

    @Override
    public PgDto updatePg(Long id, PgDto pgDto) {

        Pg pg = pgRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PG Not Found"));

        pg.setPgName(pgDto.getPgName());
        pg.setOwnerName(pgDto.getOwnerName());
        pg.setCity(pgDto.getCity());
        pg.setTotalRooms(pgDto.getTotalRooms());
        pg.setAvailableRooms(pgDto.getAvailableRooms());

        return convertToDto(pgRepository.save(pg));
    }

    @Override
    public PgDto getPgById(Long id) {

        return convertToDto(pgRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PG Not Found")));
    }

    @Override
    public List<PgDto> getAllPg() {

        List<PgDto> list = new ArrayList<>();

        for (Pg pg : pgRepository.findAll()) {
            list.add(convertToDto(pg));
        }

        return list;
    }

    @Override
    public void deletePg(Long id) {
        pgRepository.deleteById(id);
    }

    private PgDto convertToDto(Pg pg) {

        PgDto dto = new PgDto();

        dto.setId(pg.getId());
        dto.setPgName(pg.getPgName());
        dto.setOwnerName(pg.getOwnerName());
        dto.setCity(pg.getCity());
        dto.setTotalRooms(pg.getTotalRooms());
        dto.setAvailableRooms(pg.getAvailableRooms());

        return dto;
    }
}