package com.generation.projeto_integrador02.service;

//all imports
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.projeto_integrador02.model.Usuario;
import com.generation.projeto_integrador02.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> getUsuarioById(Long id) {
		return usuarioRepository.findById(id);
	}

	public Usuario createUsuario(Usuario usuario) {
		usuario.setId(null); // Garantir que o ID seja nulo para criar um novo registro
		usuario.setFoto(usuario.getFoto()); // Garantir que a foto seja definida, se fornecida
		usuario.setNome(usuario.getNome()); // Garantir que o nome seja definido, se fornecido
		usuario.setIdade(usuario.getIdade());// Garantir que a idade seja definida, se fornecida
		return usuarioRepository.save(usuario);
	}

	public Optional<Usuario> updateUsuario(Long id, Usuario usuario) {
		return usuarioRepository.findById(id).map(existingUsuario -> {
			if (usuario.getNome() != null) {
				existingUsuario.setNome(usuario.getNome());
			}
			if (usuario.getEmail() != null) {
				existingUsuario.setEmail(usuario.getEmail());
			}
			if (usuario.getFoto() != null) {
				existingUsuario.setFoto(usuario.getFoto());
			}
			if (usuario.getIdade() != null) {
				existingUsuario.setIdade(usuario.getIdade());
			}
			return usuarioRepository.save(existingUsuario);
		});
	}

	public boolean deleteUsuario(Long id) {
		if (usuarioRepository.existsById(id)) {
			usuarioRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
