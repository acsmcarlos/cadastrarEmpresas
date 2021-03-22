package com.emissaoguias.fgf.repository;

import org.springframework.data.repository.CrudRepository;

import com.emissaoguias.fgf.models.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, String> {
	
	Empresa findById(long id);

}
