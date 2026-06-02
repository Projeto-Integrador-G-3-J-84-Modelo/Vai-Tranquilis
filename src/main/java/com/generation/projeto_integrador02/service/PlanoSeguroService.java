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

    public PlanoSeguro guardar(PlanoSeguro planoSeguro) {
        return planoSeguroRepository.save(planoSeguro);
    }

    // 2. R (Read) - Listar todos os planos.
    public List<PlanoSeguro> listarTodos() {
        return planoSeguroRepository.findAll();
    }

    // 3. R (Read) - Buscar por ID.
    public Optional<PlanoSeguro> buscarPorId(Long id) {
        return planoSeguroRepository.findById(id);
    }

    // 4. D (Delete) - Apagar um plano.
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