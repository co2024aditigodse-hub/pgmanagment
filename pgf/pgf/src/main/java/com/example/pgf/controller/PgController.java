package com.example.pgf.controller;

import com.example.pgf.dto.PgDto;
import com.example.pgf.service.PgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pg")
public class PgController {

    @Autowired
    private PgService pgService;

    @PostMapping
    public PgDto savePg(@RequestBody PgDto pgDto) {
        return pgService.savePg(pgDto);
    }

    @GetMapping
    public List<PgDto> getAllPg() {
        return pgService.getAllPg();
    }

    @GetMapping("/{id}")
    public PgDto getPg(@PathVariable Long id) {
        return pgService.getPgById(id);
    }

    @PutMapping("/{id}")
    public PgDto updatePg(@PathVariable Long id,
                          @RequestBody PgDto pgDto) {
        return pgService.updatePg(id, pgDto);
    }

    @DeleteMapping("/{id}")
    public String deletePg(@PathVariable Long id) {
        pgService.deletePg(id);
        return "PG Deleted Successfully";
    }
}