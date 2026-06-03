package com.generation.projeto_integrador02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.projeto_integrador02.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    public List<Usuario> findAllByEmailContainingIgnoreCase(String email);
}