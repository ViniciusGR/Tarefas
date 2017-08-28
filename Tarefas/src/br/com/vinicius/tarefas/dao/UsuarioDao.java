package br.com.vinicius.tarefas.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import br.com.vinicius.tarefas.modelo.Usuario;

@Repository
public class UsuarioDao {
	@PersistenceContext
	private EntityManager manager;

	public void adiciona(Usuario usuario) {
		manager.persist(usuario);
	}

	public boolean valida(Usuario usuario, HttpSession session) {
		Query query = manager.createQuery("SELECT u FROM Usuario as u WHERE u.usuario = :usuario AND u.senha = :senha");
		query.setParameter("usuario", usuario.getUsuario());
		query.setParameter("senha", usuario.getSenha());
		if (query.getResultList().isEmpty()) {
			return false;
		}
		usuario = (Usuario) query.getSingleResult();
		session.setAttribute("usuarioLogado", usuario);
		return true;
	}
}
