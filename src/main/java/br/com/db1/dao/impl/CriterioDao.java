package br.com.db1.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.db1.dao.DAO;
import br.com.db1.dao.Transactional;
import br.com.db1.model.Criterio;

public class CriterioDao implements DAO<Criterio> {

	@Inject
	private EntityManager manager;

	public List<Criterio> findAll() {
		return manager.createQuery("Select c from Criterio c").getResultList();
	}

	public Criterio findById(Long id) {
		Query query = manager.createQuery("Select c from Criterio c where c.id = :pId");
		query.setParameter("pId", id);
		return (Criterio) query.getSingleResult();
	}

	public List<Criterio> findByName(String descricao) {
		Query query = manager.createQuery("Select c from Criterio c where c.descricao like:pDescricao");
		query.setParameter("pDescricao", "%"+descricao+"%");
		return query.getResultList();
	}

	@Transactional
	public boolean save(Criterio criterio) {
		try {
			if (criterio.getId() != null) {
				manager.merge(criterio);
			} else {
				manager.persist(criterio);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean delete(Long id) {
		Criterio criterio = findById(id);
		try {
			manager.remove(criterio);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
