package com.generation.projeto_integrador02.repository;

import com.generation.projeto_integrador02.model.SeguroVida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeguroVidaRepository extends JpaRepository<SeguroVida, Long> {
    
    // Busca parcial pelo nome do segurado
    List<SeguroVida> findAllByNomeSeguradoContainingIgnoreCase(String nomeSegurado);
}