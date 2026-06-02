package com.generation.projeto_integrador02.repository;

import com.generation.projeto_integrador02.model.PlanoSeguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanoSeguroRepository extends JpaRepository<PlanoSeguro, Long> {
    
    // Busca parcial ignorando maiúsculas/minúsculas pela descrição do plano
    List<PlanoSeguro> findAllByDescricaoContainingIgnoreCase(String descricao);
}