package br.com.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.livraria.DAO.LivroDAO;
import br.com.livraria.repository.LivrariaRepository;

@Controller
@RequestMapping("/livro")
public class LivrariaController {
	
	@Autowired
	private LivrariaRepository livraria;
	
	@RequestMapping()
	public String menu() {
		return "Menu";
	}
	
	@RequestMapping("menu/novo")
	public String novo() {
		return "CadastroLivro";
	}
	
	@RequestMapping("menu/pesquisalivro")
	public ModelAndView pesquisarLivro() {
		List<LivroDAO> listatodos = livraria.findAll();
		ModelAndView mv = new ModelAndView("PesquisaLivro");
		mv.addObject("listalivro", listatodos);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(LivroDAO livroDAO) {
		livraria.save(livroDAO);
		
		ModelAndView mv = new ModelAndView("/CadastroLivro");
		
		mv.addObject("mensagem", "Cadastro salvo com sucesso !!!");
		
		return mv;
	}

}
