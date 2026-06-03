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

import com.generation.projeto_integrador02.model.PlanoSeguro;
import com.generation.projeto_integrador02.model.SeguroVida;
import com.generation.projeto_integrador02.repository.PlanoSeguroRepository;
import com.generation.projeto_integrador02.service.PlanoSeguroService;
import com.generation.projeto_integrador02.service.SeguroVidaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/planos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlanoSeguroController {

	@Autowired
	private PlanoSeguroService planoService;
	
	@Autowired
	private PlanoSeguroRepository planoRepository;

	@Autowired
	private SeguroVidaService seguroVidaService;

	@GetMapping
    public ResponseEntity<List<PlanoSeguro>> listarTodos(){
        return ResponseEntity.ok(planoRepository.findAll());
    }

	@GetMapping("/{id}")
    public ResponseEntity<PlanoSeguro> buscarPorId(@PathVariable Long id){
        return planoRepository.findById(id)
            .map(resposta -> ResponseEntity.ok(resposta))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }	
	
	@GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<PlanoSeguro>> buscarDescricao(@PathVariable String descricao){
		    return ResponseEntity.ok(planoRepository.findAllByDescricaoContainingIgnoreCase(descricao));
    }
	
	@PostMapping("/cadastrar")
    public ResponseEntity<PlanoSeguro> criar(@Valid @RequestBody PlanoSeguro planoSeguro){
    	
    	planoSeguro.setId(null);
    	
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(planoRepository.save(planoSeguro));
    }
    
    @PutMapping("/atualizar")
    public ResponseEntity<PlanoSeguro> atualizar(@Valid @RequestBody PlanoSeguro planoSeguro){
        return planoRepository.findById(planoSeguro.getId())
            .map(resposta -> ResponseEntity.status(HttpStatus.OK)
            .body(planoRepository.save(planoSeguro)))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        Optional<PlanoSeguro> plano = planoRepository.findById(id);
        
        if(plano.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        
        planoRepository.deleteById(id);              
    }
}