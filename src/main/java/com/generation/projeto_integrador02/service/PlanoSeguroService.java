package com.generation.projeto_integrador02.service; 

import com.generation.projeto_integrador02.model.PlanoSeguro;
import com.generation.projeto_integrador02.repository.PlanoSeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
            // Se não existir, emite o erro 404 (Not Found).
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plano de Seguro não encontrado!");
        }
    }

    // 5. Busca Customizada.
    public List<PlanoSeguro> buscarPorDescricao(String descricao) {
        return planoSeguroRepository.findAllByDescricaoContainingIgnoreCase(descricao);
    }
}