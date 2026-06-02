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

    
    //* lista todos
    public List<SeguroVida> listarTodos() {
        return seguroVidaRepository.findAll();
    }

    //* busca por um id 
    
    public Optional<SeguroVida> buscarPorId(Long id) {
        return seguroVidaRepository.findById(id);
    }

    //* cadastra um id 
    
    public SeguroVida criar(SeguroVida seguroVida) {
        return seguroVidaRepository.save(seguroVida);
    }

    //* atualiza um id
    
    public SeguroVida atualizar(SeguroVida seguroVida) {
        if (seguroVidaRepository.existsById(seguroVida.getId())) {
            return seguroVidaRepository.save(seguroVida);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Seguro de Vida não encontrado!");
    }
    
//* deleta um id
    
    public void deletar(Long id) {
        if (seguroVidaRepository.existsById(id)) {
            seguroVidaRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Seguro de Vida não encontrado!");
        }
    }

    public String verificarElegibilidade(Long id) {
        SeguroVida seguro = seguroVidaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seguro de vida não encontrado!"));

        if (seguro.getUsuario() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este seguro não possui um usuário vinculado para checar a idade!");
        }

        //* verifica a idade pelo usuario
        
        if (seguro.getUsuario().getIdade() < 18) {
            return "Não elegível para este tipo de seguro.";
        }
        
        return "Elegível para o seguro de vida.";
    }
}