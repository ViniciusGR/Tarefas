package br.com.vinicius.tarefas.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.vinicius.tarefas.dao.TarefaDao;
import br.com.vinicius.tarefas.modelo.Tarefa;

@Transactional
@Controller
public class TarefasController {
	@Autowired
	private TarefaDao dao;

	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "tarefa/formulario";
		}
		dao.adiciona(tarefa, session);
		return "redirect:listaTarefas";
	}

	@RequestMapping("listaTarefas")
	public String lista(Model model, HttpSession session) {
		List<Tarefa> tarefas = dao.lista(session);
		model.addAttribute("tarefas", tarefas);
		return "tarefa/lista";
	}

	@RequestMapping("removeTarefa")
	public String remove(Long id, HttpSession session) {
		dao.remove(id, session);
		return "redirect:listaTarefas";
	}

	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model, HttpSession session) {
		Tarefa tarefa = dao.buscaPorId(id, session);
		model.addAttribute("tarefa", tarefa);
		return "tarefa/mostra";
	}

	@RequestMapping("alteraTarefa")
	public String altera(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasErrors()) {
			return "tarefa/mostra";
		}
		dao.altera(tarefa);
		return "redirect:listaTarefas";
	}

	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, HttpSession session) {
		dao.finaliza(id, session);
		return "redirect:listaTarefas";
	}
}
