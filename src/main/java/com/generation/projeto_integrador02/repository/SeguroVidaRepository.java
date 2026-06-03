package com.generation.projeto_integrador02.repository;

import com.generation.projeto_integrador02.model.SeguroVida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SeguroVidaRepository extends JpaRepository<SeguroVida, Long> {
    
	   // 1. Busca contratos filtrando por parte do NOME DO USUÁRIO
    // eguroVida.usuario.nome
    public List<SeguroVida> findAllByUsuarioNomeContainingIgnoreCase(String nomeUsuario);

    // 2. Busca contratos filtrando por parte do NOME DO PLANO
    // seguroVida.planoSeguro.nomePlano
    public List<SeguroVida> findAllByPlanoSeguroNomePlanoContainingIgnoreCase(String nomePlano);
}