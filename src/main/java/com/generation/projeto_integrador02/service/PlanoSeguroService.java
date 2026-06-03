package com.generation.projeto_integrador02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.projeto_integrador02.model.PlanoSeguro;
import com.generation.projeto_integrador02.repository.PlanoSeguroRepository;

@Service
public class PlanoSeguroService {

    @Autowired
    private PlanoSeguroRepository planoSeguroRepository;
    
    public List<PlanoSeguro> listarTodos() {
        return planoSeguroRepository.findAll();
    }
    
    public Optional<PlanoSeguro> buscarPorId(Long id) {
        return planoSeguroRepository.findById(id);
    }
    
    public PlanoSeguro criar(PlanoSeguro planoSeguro) {
        return planoSeguroRepository.save(planoSeguro);
    }
    
    public PlanoSeguro atualizar(PlanoSeguro planoSeguro) {
        if (!planoSeguroRepository.existsById(planoSeguro.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return planoSeguroRepository.save(planoSeguro);
    }
    
    public void apagar(Long id) {
        if(planoSeguroRepository.existsById(id)) {
            planoSeguroRepository.deleteById(id);
        } else {
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plano de Seguro não encontrado!");
        }
    }
    
    public List<PlanoSeguro> buscarPorDescricao(String descricao) {
        return planoSeguroRepository.findAllByDescricaoContainingIgnoreCase(descricao);
    }
    


}