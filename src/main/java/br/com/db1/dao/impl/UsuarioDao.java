package br.com.db1.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.db1.dao.DAO;
import br.com.db1.dao.Transactional;
import br.com.db1.model.Usuario;

public class UsuarioDao implements DAO<Usuario> {

	@Inject
	
	private EntityManager manager;

	public List<Usuario> findAll() {
		return manager.createQuery("Select u from Usuario u").getResultList();
	}

	public Usuario findById(Long id) {
		Query query = manager.createQuery("Select u from Usuario u where u.id = :pId");
		query.setParameter("pId", id);
		return (Usuario) query.getSingleResult();
	}

	public List<Usuario> findByName(String nome) {
		Query query = manager.createQuery("Select u from Usuario u where u.nome like :pNome");
		query.setParameter("pNome", "%"+nome+"%");
		return query.getResultList();
	}
	
	@Transactional
	public boolean save(Usuario usuario) {
		try {
			if (usuario.getId() != null) {
				manager.merge(usuario);
			} else {
				manager.persist(usuario);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean delete(Long id) {
		Usuario usuario= findById(id);
		try {
			manager.remove(usuario);
		} catch (Exception e) {
			return false;
		}
		return true;

	}
	

}