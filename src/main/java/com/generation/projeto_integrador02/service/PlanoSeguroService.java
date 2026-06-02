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
    
    //* Lista todos os planos de seguro cadastrados

    public List<PlanoSeguro> listarTodos() {
        return planoSeguroRepository.findAll();
    }
    
  //*Busca um plano de seguro pelo seu ID.
    
    public Optional<PlanoSeguro> buscarPorId(Long id) {
        return planoSeguroRepository.findById(id);
    }
//* Cadastra um novo plano de seguro no banco de dados.
    
    public PlanoSeguro criar(PlanoSeguro planoSeguro) {
        return planoSeguroRepository.save(planoSeguro);
    }
    
//* Atualiza um plano de seguro existente. 
  //  * Lança erro 404 caso o ID informado não exista.

    public PlanoSeguro atualizar(PlanoSeguro planoSeguro) {
        if (planoSeguroRepository.existsById(planoSeguro.getId())) {
            return planoSeguroRepository.save(planoSeguro);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plano de Seguro não encontrado!");
    }
    
//* Exclui um plano de seguro pelo ID.
    public void deletar(Long id) {
        if (planoSeguroRepository.existsById(id)) {
            planoSeguroRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plano de Seguro não encontrado!");
        }
    }
}