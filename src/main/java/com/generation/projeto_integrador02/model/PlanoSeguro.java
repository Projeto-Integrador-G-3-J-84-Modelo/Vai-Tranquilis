package com.generation.projeto_integrador02.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
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
	@Size(max = 50, message = "O atributo Nome do Plano deve conter no máximo 50 caracteres")
	private String nomePlano;

	@NotBlank
	@Size(max = 200, message = "O atributo Descrição deve conter no máximo 200 caracteres")
	private String descricao;

	@NotNull(message = "O atributo Indenização Maxima é obrigatório.")
	@DecimalMin(value = "0.01", message = "O atributo Indenização Maxima deve ser um valor positivo.")
	private Double indenizacaoMaxima;
	
	/*@ManyToOne
	@JsonIgnoreProperties("planoSeguro")
	private SeguroVida seguroVida;*/
	
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

	public Double getIndenizacaoMaxima() {
		return indenizacaoMaxima;
	}

	public void setIndenizacaoMaxima(Double indenizacaoMaxima) {
		this.indenizacaoMaxima = indenizacaoMaxima;
	}

	/*public SeguroVida getSeguroVida() {
		return seguroVida;
	}

	public void setSeguroVida(SeguroVida seguroVida) {
		this.seguroVida = seguroVida;
	}*/



}
