package com.generation.projeto_integrador02.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.generation.projeto_integrador02.model.SeguroVida;
import com.generation.projeto_integrador02.repository.SeguroVidaRepository;

@Service
public class SeguroVidaService {

    @Autowired
    private SeguroVidaRepository seguroVidaRepository;

    public List<SeguroVida> listarTodos() {
        return seguroVidaRepository.findAll();
    }

    public Optional<SeguroVida> buscarPorId(Long id) {
        return seguroVidaRepository.findById(id);
    }

    public SeguroVida criar(SeguroVida seguro) {
        return seguroVidaRepository.save(seguro);
    }

    public SeguroVida atualizar(SeguroVida seguro) {
        if (seguroVidaRepository.existsById(seguro.getId())) {
            return seguroVidaRepository.save(seguro);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Seguro de vida não encontrado!");
    }

    public void deletar(Long id) {
        if (seguroVidaRepository.existsById(id)) {
            seguroVidaRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Seguro de vida não encontrado!");
        }
    }

    public String verificarElegibilidade(Long id) {
        SeguroVida seguro = seguroVidaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seguro não encontrado!"));

        if (seguro.getIdade() < 18) {
            return "Não elegível para este tipo de seguro.";
        }
        
        return "Elegível para o seguro de vida.";
    }
}
