package com.generation.projeto_integrador02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.projeto_integrador02.model.SeguroVida;
import com.generation.projeto_integrador02.repository.SeguroVidaRepository;
import com.generation.projeto_integrador02.service.SeguroVidaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/seguros")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SeguroVidaController {
	
	
    @Autowired
    private SeguroVidaRepository seguroRepository;
    
    @Autowired
    private SeguroVidaService seguroService;


	@GetMapping
    public ResponseEntity<List<SeguroVida>> listarTodos(){
        return ResponseEntity.ok(seguroRepository.findAll());
    }

	@GetMapping("/{id}")
    public ResponseEntity<SeguroVida> buscarPorId(@PathVariable Long id){
        return seguroRepository.findById(id)
            .map(resposta -> ResponseEntity.ok(resposta))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
	
	@GetMapping("/usuarios/{nome}")
	public ResponseEntity<List<SeguroVida>> buscarPorNomeUsuario(@PathVariable String nome) {
	    return ResponseEntity.ok(seguroRepository.findAllByUsuarioNomeContainingIgnoreCase(nome));
	}

	@GetMapping("/planos/{nome}")
	public ResponseEntity<List<SeguroVida>> buscarPorNomePlano(@PathVariable String nome) {
	    return ResponseEntity.ok(seguroRepository.findAllByPlanoSeguroNomePlanoContainingIgnoreCase(nome));
	}
	
	@PostMapping("/cadastrar")
    public ResponseEntity<SeguroVida> criar(@Valid @RequestBody SeguroVida seguroVida) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(seguroService.criar(seguroVida));
    }
	
	
    @PutMapping("/atualizar")
    public ResponseEntity<SeguroVida> put(@Valid @RequestBody SeguroVida seguroVida) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(seguroService.atualizar(seguroVida));
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<SeguroVida> seguro = seguroRepository.findById(id);
        
        if(seguro.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        seguroRepository.deleteById(id);              
    }
}

