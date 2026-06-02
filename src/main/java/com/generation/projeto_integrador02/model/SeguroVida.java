package com.generation.projeto_integrador02.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_seguroVida")
public class SeguroVida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 120, message = "O atributo nome do seguro deve conter no máximo 120 caracteres")
	private String nomeSegurado;
	
	@NotNull
	private Byte idade;

	@NotNull
	private Integer valorCobertura;
	
	@NotNull
	private Integer valorMensalidade;
	
	@NotBlank
	@Size(max = 50, message = "O atributo senha deve conter no máximo 50 caracteres")
	private String senha;
	
	@OneToMany
	@JsonIgnoreProperties("seguro") 
	private Usuario usuario;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeSegurado() {
		return nomeSegurado;
	}

	public void setNomeSegurado(String nomeSegurado) {
		this.nomeSegurado = nomeSegurado;
	}

	public Byte getIdade() {
		return idade;
	}

	public void setIdade(Byte idade) {
		this.idade = idade;
	}

	public Integer getValorCobertura() {
		return valorCobertura;
	}

	public void setValorCobertura(Integer valorCobertura) {
		this.valorCobertura = valorCobertura;
	}

	public Integer getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(Integer valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
