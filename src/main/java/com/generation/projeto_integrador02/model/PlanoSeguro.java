package com.generation.projeto_integrador02.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_planoSeguro")
public class PlanoSeguro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 50, message = "O atributo nome do plano deve conter no máximo 50 caracteres")
	private String nomePlano;
	
	@NotBlank
	@Size(max = 200, message = "O atributo descrição deve conter no máximo 200 caracteres")
	private String descricao;
	
	@NotNull
	private Double coberturaMaxima;
	
	@ManyToOne
	private PlanoSeguro plano;
	
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
