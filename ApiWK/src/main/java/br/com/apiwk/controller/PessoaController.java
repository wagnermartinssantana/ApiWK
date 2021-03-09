package br.com.apiwk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.apiwk.models.Pessoa;
import br.com.apiwk.repository.PessoaRepository;

@Controller 
public class PessoaController {
	
	@Autowired
	private PessoaRepository pr;
	
	
	@RequestMapping(value="/cadastrarPessoa", method=RequestMethod.GET)
	public String form() {
		return "cadastrarPessoa";
	}

	@RequestMapping(value="/cadastrarPessoa", method=RequestMethod.POST)
	public String form(Pessoa  pessoa)  {
	
		pr.save(pessoa);
		return "redirect:/cadastrarPessoa";
	} 
	
	@RequestMapping("/pessoas")
	public ModelAndView listaPessoas() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Pessoa> pessoas = pr.findAll();
		mv.addObject("pessoas", pessoas);
		return mv;
	}
	
	
	@RequestMapping("/{id}")
	public ModelAndView detalhesPessoa(@PathVariable("id") long id) {
		Pessoa pessoa = pr.findById(id);
		ModelAndView mv = new ModelAndView("detalhesPessoa");
		mv.addObject("pessoa", pessoa);
		return mv;
	}
	
	/*

	@RequestMapping("/{estado}")
	public ModelAndView pessoasEstado(@PathVariable("estado") String estado) {
		Pessoa pessoa = pr.findByEstado(estado);
		ModelAndView mv = new ModelAndView("pessoasEstado");
		mv.addObject("pessoa", pessoa);
		return mv;
	}
*/
	
	@RequestMapping("/deletar")
	public String deletarPessoa(long id) {
			Pessoa pessoa = pr.findById(id);
			pr.delete(pessoa);
	return "redirect:/pessoas";
	}
	
	
	
	@PutMapping("")
	public Pessoa atualizarPessoa(@RequestBody Pessoa pessoa) {
		return pr.save(pessoa);
		
		
	}	
	
}
