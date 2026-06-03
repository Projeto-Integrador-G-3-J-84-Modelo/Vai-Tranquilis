package com.generation.projeto_integrador02.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "tb_seguroVida")
public class SeguroVida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double valorMensalidade; 
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataContratacao = LocalDate.now();

    @ManyToOne
    @NotNull(message = "O plano de seguro é obrigatório.")
	@JsonIgnoreProperties("seguroVida")
    private PlanoSeguro planoSeguro;

    @ManyToOne
    @NotNull(message = "O usuário é obrigatório.")
	@JsonIgnoreProperties("seguros")
    private Usuario usuario;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(Double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public PlanoSeguro getPlanoSeguro() {
		return planoSeguro;
	}

	public void setPlanoSeguro(PlanoSeguro planoSeguro) {
		this.planoSeguro = planoSeguro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
