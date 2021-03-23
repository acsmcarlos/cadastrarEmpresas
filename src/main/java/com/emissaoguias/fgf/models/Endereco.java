package com.emissaoguias.fgf.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Endereco {
	
	@Id
	@NotEmpty
	private Long id;
	
	private String cidade;
	private String estado;
	
	@OneToOne
	private Empresa empresa;

}
