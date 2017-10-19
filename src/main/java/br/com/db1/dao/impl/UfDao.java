package br.com.db1.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.db1.dao.DAO;
import br.com.db1.dao.Transactional;
import br.com.db1.model.Uf;

public class UfDao implements DAO<Uf> {

	@Inject
	private EntityManager manager;

	public List<Uf> findAll() {
		return manager.createQuery("Select u from Uf u").getResultList();
	}

	public Uf findById(Long id) {
		Query query = manager.createQuery("Select u from Uf u where u.id = :pId");
		query.setParameter("pId", id);
		return (Uf) query.getSingleResult();
	}

	public List<Uf> findByName(String nome) {
		Query query = manager.createQuery("Select u from Uf u where u.nome like :pNome");
		query.setParameter("pNome", "%" + nome + "%");
		return query.getResultList();
	}

	@Transactional
	public boolean save(Uf uf) {
		try {
			if (uf.getId() != null) {
				manager.merge(uf);
			} else {
				manager.persist(uf);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean delete(Long id) {
		Uf uf = findById(id);
		try {
			manager.remove(uf);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

}
