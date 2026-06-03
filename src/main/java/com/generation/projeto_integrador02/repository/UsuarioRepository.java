package com.generation.projeto_integrador02.repository;

import com.generation.projeto_integrador02.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // Busca exata pelo e-mail do usuário
    Optional<Usuario> findByEmail(String email);
}