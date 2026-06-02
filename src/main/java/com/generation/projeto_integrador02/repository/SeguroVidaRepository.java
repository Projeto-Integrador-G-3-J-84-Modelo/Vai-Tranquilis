package com.generation.projeto_integrador02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.projeto_integrador02.model.SeguroVida;

@Repository
public interface SeguroVidaRepository extends JpaRepository<SeguroVida, Long> {
}
