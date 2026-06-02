package com.generation.projeto_integrador02.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.generation.projeto_integrador02.model.SeguroVida;
import com.generation.projeto_integrador02.service.SeguroVidaService;

@RestController
@RequestMapping("/seguros")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SeguroVidaController {

    @Autowired
    private SeguroVidaService seguroVidaService;

    @GetMapping
    public ResponseEntity<List<SeguroVida>> getAll() {
        return ResponseEntity.ok(seguroVidaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeguroVida> getById(@PathVariable Long id) {
        return seguroVidaService.buscarPorId(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SeguroVida> post(@Valid @RequestBody SeguroVida seguro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(seguroVidaService.criar(seguro));
    }

    @PutMapping
    public ResponseEntity<SeguroVida> put(@Valid @RequestBody SeguroVida seguro) {
        return ResponseEntity.ok(seguroVidaService.atualizar(seguro));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        seguroVidaService.deletar(id);
  
        
    }
}
