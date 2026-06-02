package com.generation.projeto_integrador02.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 120, message = "O atributo nome deve conter no máximo 120 caracteres")
	private String nome;

	@NotBlank
	@Size(max = 120, message = "O atributo e-mail deve conter no máximo 120 caracteres")
	private String email;

	// atributo foto
	@Size(max = 255, message = "O atributo foto deve conter no máximo 255 caracteres")
	private String foto;
	
	@NotNull
	private Integer idade; 

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "usuario", allowSetters = true)
	private List<SeguroVida> seguroVida;
	
	// Getters e SEtters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

<<<<<<< HEAD
    public List<SeguroVida> getSeguro() {
        return seguro;
    }

    public void setSeguro(List<SeguroVida> seguro) {
        this.seguro = seguro;
    }
=======
	public List<SeguroVida> getSeguroVida() {
		return seguroVida;
	}

	public void setSeguroVida(List<SeguroVida> seguroVida) {
		this.seguroVida = seguroVida;
	}

>>>>>>> f3db01923e2b6274e88ace75af45da12a6e78007

}
