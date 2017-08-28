package br.com.vinicius.tarefas.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.vinicius.tarefas.dao.UsuarioDao;
import br.com.vinicius.tarefas.modelo.Usuario;

@Transactional
@Controller
public class UsuariosController {
	private UsuarioDao dao;
	
	@Autowired
	public UsuariosController(UsuarioDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("loginForm")
	public String form() {
		return "tarefa/login";
	}
		
	@RequestMapping("efetuaLogin")
	public String login(Usuario usuario, HttpSession session) {
		if(dao.valida(usuario, session)) {
			return "redirect:listaTarefas";
		}
		return "redirect:loginForm";
	}
	
	@RequestMapping("cadastroForm")
	public String cadastroForm() {
		return "tarefa/cadastro";
	}
	
	@RequestMapping("cadastraUsuario")
	public String cadastrar(@Valid Usuario usuario, BindingResult result) {
		if(result.hasErrors()) {
			return "tarefa/cadastro";
		}
		dao.adiciona(usuario);
		return "redirect:loginForm";
		
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}
}
