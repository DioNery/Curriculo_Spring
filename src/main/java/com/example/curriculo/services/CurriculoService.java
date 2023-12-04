package com.example.curriculo.services;

import com.example.curriculo.models.Curriculo;
import com.example.curriculo.repositories.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurriculoService {

    private final CurriculoRepository curriculoRepository;

    @Autowired
    public CurriculoService(CurriculoRepository curriculoRepository) {
        this.curriculoRepository = curriculoRepository;
    }

    public List<Curriculo> getAllCurriculos() {
        return curriculoRepository.findAll();
    }

    public Optional<Curriculo> getCurriculoById(Long id) {
        return curriculoRepository.findById(id);
    }

    public Curriculo saveCurriculo(Curriculo curriculo) {
        return curriculoRepository.save(curriculo);
    }

    public void deleteCurriculo(Long id) {
        curriculoRepository.deleteById(id);
    }
}