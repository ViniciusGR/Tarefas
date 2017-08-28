package br.com.vinicius.tarefas.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import br.com.vinicius.tarefas.modelo.Tarefa;
import br.com.vinicius.tarefas.modelo.Usuario;

@Repository
public class TarefaDao {

	@PersistenceContext
	private EntityManager manager;

	public void adiciona(Tarefa tarefa, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		usuario = manager.find(Usuario.class, usuario.getId());
		usuario.getTarefas().add(tarefa);
		manager.merge(usuario);
	}


	public List<Tarefa> lista(HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		usuario = manager.find(Usuario.class, usuario.getId());
		return usuario.getTarefas();
	}

	public Tarefa buscaPorId(Long id, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		Query query = manager.createQuery("SELECT t FROM Tarefa as t WHERE id = :id AND id_usuario = :id_usuario");
		query.setParameter("id", id);
		query.setParameter("id_usuario", usuario.getId());
		return (Tarefa) query.getSingleResult();
	}

	public void remove(Long id, HttpSession session) {
		Tarefa tarefa = buscaPorId(id, session);
		manager.remove(tarefa);
		manager.flush();
	}

	public void altera(Tarefa tarefa) {
		manager.merge(tarefa);
	}

	public boolean finaliza(Long id, HttpSession session) {
		Tarefa tarefa = buscaPorId(id, session);
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(Calendar.getInstance());
		manager.merge(tarefa);
		return true;
	}
}