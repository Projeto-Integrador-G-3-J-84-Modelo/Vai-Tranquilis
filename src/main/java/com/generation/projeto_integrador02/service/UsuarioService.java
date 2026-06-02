package com.generation.projeto_integrador02.service;

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
        usuario.setId(null); 
        usuario.setSenha(usuario.getSenha());
        usuario.setFoto(usuario.getFoto()); 
        usuario.setNome(usuario.getNome()); 
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
            if (usuario.getSenha() != null) {
                existingUsuario.setSenha(usuario.getSenha());
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
