package com.generation.projeto_integrador02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.projeto_integrador02.model.Usuario;
import com.generation.projeto_integrador02.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Lista todos os usuários cadastrados no sistema.
     */
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    /**
     * Busca um usuário específico pelo ID.
     */
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    /**
     * Cadastra um novo usuário
     */
    public Usuario criar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Atualiza os dados de um usuário existente.
     */
    public Usuario atualizar(Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getId())) {
            return usuarioRepository.save(usuario);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!");
    }

    /**
     * Deleta um usuário pelo ID.
     */
    public void deletar(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!");
        }
    }
}