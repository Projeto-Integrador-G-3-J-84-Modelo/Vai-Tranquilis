package com.generation.projeto_integrador02.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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

	@NotBlank
	@Size(max = 100, message = "O atributo foto deve conter no máximo 100 caracteres")
	private String foto;
	
	@NotBlank
	@Size(max = 50, message = "O atributo eenha deve conter no máximo 50 caracteres")
	private String senha;
}
