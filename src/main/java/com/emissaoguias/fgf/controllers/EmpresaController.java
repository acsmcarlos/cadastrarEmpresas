package com.emissaoguias.fgf.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String form(@Valid Empresa empresa, BindingResult result, RedirectAttributes attributes) {
		if (empresa.getNome().equals("") || empresa.getCnpj().equals("") || empresa.getDtPagamento().equals("")
				|| empresa.getDtVencimento().equals("") || empresa.getMes().equals("") || empresa.getNumDoc().equals("")
				|| empresa.getVlReceita().equals("")) {
			attributes.addFlashAttribute("mensagem", "Preencha os campos obrigatórios!");
			return "redirect:/cadastrarEmpresa";
		} else {
			er.save(empresa);
			attributes.addFlashAttribute("mensagem2", "Empresa cadastrada com sucesso!"); // ERRO: Não ta salvando novo
			return "redirect:/cadastrarEmpresa";
		}
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
	
	@RequestMapping("/deletar")
	public String deletarEmpresa(long id) {
		Empresa empresa = er.findById(id);
		er.delete(empresa);
		return "redirect:/empresas";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String detalhesEmpresaPost(@PathVariable("id") long id, @Valid Endereco endereco,
			RedirectAttributes attributes) {

		if (endereco.getCidade().equals("") || endereco.getEstado().equals("")) {
			attributes.addFlashAttribute("mensagem", "Os campo CIDADE e ESTADO são obrigatórios!");
			return "redirect:/{id}";
		} else {
			Empresa empresa = er.findById(id);
			endereco.setEmpresa(empresa);
			cr.save(endereco);
			attributes.addFlashAttribute("mensagem2", "Endereço adicionado com sucesso!");
			return "redirect:/{id}";
		}
	}

}
