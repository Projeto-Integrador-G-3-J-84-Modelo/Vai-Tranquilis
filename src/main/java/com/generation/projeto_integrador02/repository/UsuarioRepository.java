package com.generation.projeto_integrador02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;  

import com.generation.projeto_integrador02.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
