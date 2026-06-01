package com.generation.projeto_integrador02.repository; // Atenção ao pacote do seu projeto

import com.generation.projeto_integrador02.model.PlanoSeguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Avisa ao Spring que este é o arquivo que vai conversar com o banco de dados
public interface PlanoSeguroRepository extends JpaRepository<PlanoSeguro, Long> {

    // Método customizado que você precisa entregar:
    // Ele vai buscar uma lista de planos onde a 'descricao' contenha a palavra que o usuário digitar, 
    // ignorando se a pessoa digitou com letra maiúscula ou minúscula (IgnoreCase).
    List<PlanoSeguro> findAllByDescricaoContainingIgnoreCase(String descricao);

}