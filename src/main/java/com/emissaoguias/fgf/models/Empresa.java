package com.emissaoguias.fgf.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty 
	@NotNull 
	@NotBlank
	@Size(min=2, max=100, message="Tem de ter pelo menos 2 letras") 
	private String nome;
	
	@NotEmpty 
	@NotNull 
	@NotBlank
	private String cnpj;
	
	@NotNull 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dtVencimento;
	
	@NotNull 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dtPagamento;
	
	@NotEmpty 
	@NotNull 
	@NotBlank
	private String numDoc;
	
	@NotEmpty 
	@NotNull(message = "Campo não pode estar vazio")
	@NotBlank
	@NumberFormat(pattern = "0.00")
	private String vlReceita;
	
	@NotEmpty 
	@NotNull 
	@NotBlank
	private String informacoes;
	
	@NotEmpty 
	@NotNull 
	@NotBlank
	private String mes;
	
	@OneToMany
	private List<Endereco> enderecos;
	
}
