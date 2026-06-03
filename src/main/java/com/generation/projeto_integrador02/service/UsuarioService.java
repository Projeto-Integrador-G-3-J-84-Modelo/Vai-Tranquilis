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

    public Optional<List<Usuario>> listarTodos() {
        return Optional.of(usuarioRepository.findAll());
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario criar(Usuario usuario) {

        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        

        if (usuarioExistente.isPresent()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "O e-mail '" + usuario.getEmail() + "' já está em uso!"
            );
        }

        // 3. Se estiver tudo certo, salva o usuário normalmente
        return usuarioRepository.save(usuario);
	}

	public Optional<Usuario> atualizar(Usuario usuario) {

		if (!usuarioRepository.findById(usuario.getId()).isPresent()) {
			return Optional.empty();
		}

		Optional<Usuario> usuarioExistente = usuarioRepository.findById(usuario.getId());
		
		if (usuarioExistente.isPresent() && !usuarioExistente.get().getId().equals(usuario.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
		}

		return Optional.of(usuarioRepository.save(usuario));
    }

}