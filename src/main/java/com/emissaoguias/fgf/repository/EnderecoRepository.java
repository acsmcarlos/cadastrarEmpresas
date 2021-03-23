package com.emissaoguias.fgf.repository;

import org.springframework.data.repository.CrudRepository;

import com.emissaoguias.fgf.models.Empresa;
import com.emissaoguias.fgf.models.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, String> {
	
	Iterable<Endereco> findByEmpresa(Empresa empresa);

}
