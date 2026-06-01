package com.generation.projeto_integrador02.controller;

import com.generation.projeto_integrador02.model.PlanoSeguro;
import com.generation.projeto_integrador02.service.PlanoSeguroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planos")
@CrossOrigin(origins = "*", allowedHeaders = "*") // Faz com que o front-end se conecte depois.
public class PlanoSeguroController {

    @Autowired
    private PlanoSeguroService planoSeguroService;

    @GetMapping
    public ResponseEntity<List<PlanoSeguro>> listarTodos() {
        return ResponseEntity.ok(planoSeguroService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoSeguro> buscarPorId(@PathVariable Long id) {
        Optional<PlanoSeguro> plano = planoSeguroService.buscarPorId(id);
        return plano.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    // 3. GET /planos/descricao/{descricao} (Busca por descrição)
    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<PlanoSeguro>> buscarPorDescricao(@PathVariable String descricao) {
        return ResponseEntity.ok(planoSeguroService.buscarPorDescricao(descricao));
    }

    // 4. POST /planos (Cria um novo plano)
    @PostMapping
    public ResponseEntity<PlanoSeguro> criar(@Valid @RequestBody PlanoSeguro planoSeguro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(planoSeguroService.guardar(planoSeguro));
    }

    // 5. PUT /planos (Atualiza um plano existente)
    @PutMapping
    public ResponseEntity<PlanoSeguro> atualizar(@Valid @RequestBody PlanoSeguro planoSeguro) {
        // Verifica se o ID foi passado e se o plano existe antes de atualizar
        if (planoSeguro.getId() == null || planoSeguroService.buscarPorId(planoSeguro.getId()).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(planoSeguroService.guardar(planoSeguro));
    }

    // 6. DELETE /planos/{id} (Apaga um plano)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apagar(@PathVariable Long id) {
        planoSeguroService.apagar(id);
    }
}