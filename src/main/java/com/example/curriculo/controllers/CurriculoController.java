package com.example.curriculo.controllers;

import com.example.curriculo.models.Curriculo;
import com.example.curriculo.services.CurriculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/curriculos")
public class CurriculoController {

    private final CurriculoService curriculoService;

    @Autowired
    public CurriculoController(CurriculoService curriculoService) {
        this.curriculoService = curriculoService;
    }

    @GetMapping
    public ResponseEntity<List<Curriculo>> getAllCurriculos() {
        List<Curriculo> curriculos = curriculoService.getAllCurriculos();
        return new ResponseEntity<>(curriculos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curriculo> getCurriculoById(@PathVariable Long id) {
        Optional<Curriculo> curriculo = curriculoService.getCurriculoById(id);
        return curriculo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Curriculo> saveCurriculo(@RequestBody Curriculo curriculo) {
        Curriculo savedCurriculo = curriculoService.saveCurriculo(curriculo);
        return new ResponseEntity<>(savedCurriculo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurriculo(@PathVariable Long id) {
        curriculoService.deleteCurriculo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}