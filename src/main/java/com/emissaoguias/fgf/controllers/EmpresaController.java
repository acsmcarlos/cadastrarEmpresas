package com.emissaoguias.fgf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.emissaoguias.fgf.models.Empresa;
import com.emissaoguias.fgf.models.Endereco;
import com.emissaoguias.fgf.repository.EmpresaRepository;
import com.emissaoguias.fgf.repository.EnderecoRepository;

@Controller
public class EmpresaController {

	@Autowired
	private EmpresaRepository er;
	
	@Autowired
	private EnderecoRepository cr;

	@RequestMapping(value = "/cadastrarEmpresa", method = RequestMethod.GET)
	public String form() {
		return "empresa/formEmpresa";
	}

	@RequestMapping(value = "/cadastrarEmpresa", method = RequestMethod.POST)
	public String form(Empresa empresa) {

		er.save(empresa);

		return "redirect:/cadastrarEmpresa";
	}

	@RequestMapping("/empresas")
	public ModelAndView listaEmpresas() {
		ModelAndView mv = new ModelAndView("/index");
		Iterable<Empresa> empresas = er.findAll();
		mv.addObject("empresas", empresas);
		return mv;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView detalhesEmpresa(@PathVariable("id") long id) {
		Empresa empresa = er.findById(id);
		ModelAndView mv = new ModelAndView("empresa/detalhesEmpresa");
		mv.addObject("empresa", empresa);
		
		Iterable<Endereco> enderecos = cr.findByEmpresa(empresa);
		mv.addObject("enderecos", enderecos);
		
		return mv;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String detalhesEmpresaPost(@PathVariable("id") long id, Endereco endereco) {
		Empresa empresa = er.findById(id);
		endereco.setEmpresa(empresa);
		cr.save(endereco);
		return "redirect:/{id}";
	}

}
