package com.generation.projeto_integrador02.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@Size(max = 50, message = "O atributo eenha deve conter no máximo 50 caracteres")
	private String senha;

}
