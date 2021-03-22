package com.emissaoguias.fgf.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	private String nome;
	private String cnpj;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dtVencimento;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dtPagamento;
	
	private String numDoc;
	
	@NumberFormat(pattern = "0.00")
	private String vlReceita;
	
	private String informacoes;
	
	private String mes;
	
	@OneToMany
	private List<Endereco> enderecos;
	
}
