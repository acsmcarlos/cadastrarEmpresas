package com.emissaoguias.fgf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmpresaController {

//	@Autowired
//	private EmpresaRepository er;

	@RequestMapping(value = "/cadastrarEmpresa", method = RequestMethod.GET)
	public String form() {
		return "empresa/formEmpresa";
	}

//	@RequestMapping(value = "/cadastrarEmpresa", method = RequestMethod.POST)
//	public String form(Empresa empresa) {
//
//		er.save(empresa);
//
//		return "redirect:/cadastrarEmpresa";
//	}

//	@RequestMapping("/empresas")
//	public ModelAndView listaEmpresas() {
//		ModelAndView mv = new ModelAndView("/index");
//		Iterable<Empresa> empresas = er.findAll();
//		mv.addObject("empresas", empresas);
//		return mv;
//	}
	
//	@RequestMapping("/{id}")
//	public ModelAndView detalhesEmpresa(@PathVariable("id") long id) {
//		Empresa empresa = er.findById(id);
//		ModelAndView mv = new ModelAndView("empresa/detalhesEmpresa");
//		mv.addObject("empresa", empresa);
//		return mv;
//	}

}
