package com.generation.projeto_integrador02.model; 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_planos_seguro")
public class PlanoSeguro {

    @Id // Diz que esse atributo é a Chave Primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gerar o ID automaticamente 
    private Long id;

    @NotBlank(message = "O nome do plano não pode ficar em branco") // Impedir que salvem um plano sem nome
    private String nomePlano;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    @NotNull(message = "A cobertura máxima não pode ser nula")
    private Double coberturaMaxima; //BigDecimal para lidar com dinheiro/valores exatos

  public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getCoberturaMaxima() {
        return coberturaMaxima;
    }

    public void setCoberturaMaxima(Double coberturaMaxima) {
        this.coberturaMaxima = coberturaMaxima;
    }
}