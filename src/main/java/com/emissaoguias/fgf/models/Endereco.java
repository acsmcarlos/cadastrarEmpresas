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
	private Long id;
	
	@NotEmpty
	private String cidade;
	
	@NotEmpty
	private String estado;
	
	@OneToOne
	private Empresa empresa;

}
