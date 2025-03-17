package com.pdcase.AppEad.AppEad.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pdcase.AppEad.AppEad.models.Aula;
import com.pdcase.AppEad.AppEad.models.Projeto;
import com.pdcase.AppEad.AppEad.repository.AulaRepository;
import com.pdcase.AppEad.AppEad.repository.ProjetoRepository;

import jakarta.validation.Valid;

@Controller
public class ProjetoController {

    @Autowired 
    private ProjetoRepository pr;

    @Autowired 
    private AulaRepository ar;

    // CADASTRAR PROJETO
    @RequestMapping(value = "/cadastrarProjeto", method = RequestMethod.GET)
    public String form() {
        return "projeto/formProjeto";
    }

    @RequestMapping(value = "/cadastrarProjeto", method = RequestMethod.POST)
    public String form(@Valid Projeto projeto, BindingResult result, RedirectAttributes attributes) {
    	if (result.hasErrors()) {
	        System.out.println(result.getAllErrors());
	        attributes.addFlashAttribute("mensagem", "Verifique os campos...");
	        return "redirect:/cadastrarProjeto";
	    }
 
	    projeto.setData_atualizacaoProjeto(LocalDateTime.now()); // Define data de atualização

        pr.save(projeto);
        attributes.addFlashAttribute("mensagem", "Projeto cadastrado com sucesso!");
        return "redirect:/projetos";
    }

    // LISTAR PROJETOS
    @RequestMapping("/projetos")
    public ModelAndView listaProjetos() {
        ModelAndView mv = new ModelAndView("projeto/listaProjeto");
        Iterable<Projeto> projetos = pr.findAll();
        mv.addObject("projetos", projetos);
        return mv;
    }

    // DETALHES DO PROJETO
    @RequestMapping(value = "projeto/{id}", method = RequestMethod.GET)
    public ModelAndView detalhesProjeto(@PathVariable("id") long id) {
        Projeto projeto = pr.findById(id);
        ModelAndView mv = new ModelAndView("projeto/detalhesProjeto");
        mv.addObject("projeto", projeto);

        Iterable<Aula> aulas = ar.findByProjeto(projeto);
        mv.addObject("aulas", aulas);

        return mv;
    }

    // DELETAR PROJETO
    @RequestMapping("/deletarProjeto")
    public String deletarProjeto(long id) {
        Projeto projeto = pr.findById(id);
        pr.delete(projeto);
        return "redirect:/projetos";
    }

    // ADICIONAR AULA A UM PROJETO
    @RequestMapping(value = "projeto/{id}", method = RequestMethod.POST)
    public String detalhesProjetoPost(@PathVariable("id") long id, @Valid Aula aula, BindingResult result, RedirectAttributes attributes) {
    	if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/{id}";
		}

        Projeto projeto = pr.findById(id);
        aula.setProjeto(projeto);
        ar.save(aula);
        attributes.addFlashAttribute("mensagem", "Aula adicionada com sucesso!");
        return "redirect:/projeto/{id}";
    }

    // DELETAR AULA
    @RequestMapping("/deletarAula")
    public String deletarAula(@RequestParam("id") Long id) {
        Aula aula = ar.getById(id);
        Projeto projeto = aula.getProjeto();
        Long id_projeto = projeto.getId_projeto();

        ar.delete(aula);

        return "redirect:/projeto/" + id_projeto;
    }

    // FORMULÁRIO DE EDIÇÃO DO PROJETO
    @RequestMapping(value="/editar-projeto", method = RequestMethod.GET)
    public ModelAndView editarProjeto(long id) {
        Projeto projeto = pr.findById(id);
        ModelAndView mv = new ModelAndView("projeto/update-projeto");
        mv.addObject("projeto", projeto);
        return mv;
    }

    // ATUALIZAR PROJETO
    @RequestMapping(value = "/editar-projeto", method = RequestMethod.POST)
    public String updateProjeto(@Valid Projeto projeto, BindingResult result, RedirectAttributes attributes) {
        pr.save(projeto);
        attributes.addFlashAttribute("sucess", "Projeto alterado com sucesso!");
        long idLong = projeto.getId_projeto();
        String id = "" + idLong;
        return "redirect:/projetos";
    }
}