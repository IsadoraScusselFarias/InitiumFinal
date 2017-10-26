package br.com.db1.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.db1.dao.DAO;
import br.com.db1.dao.Transactional;
import br.com.db1.model.Prova;

public class ProvaDao implements DAO<Prova>{

	@Inject
	private EntityManager manager;
	
	public List<Prova> findAll() {
		return manager.createQuery("Select p from Prova p").getResultList();
	}

	public Prova findById(Long id) {
		Query query = manager.createQuery("Select p from Prova p where p.id = :pId");
		query.setParameter("pId", id);
		return (Prova) query.getSingleResult();
	}

	public List<Prova> findByName(String parecer) {
		Query query = manager.createQuery("Select p from Prova p where p.parecer like:pParecer");
		query.setParameter("pParecer", "%"+parecer+"%");
		return query.getResultList();
	}

	@Transactional
	public boolean save(Prova prova) {
		try {
			if (prova.getId() != null) {
				manager.merge(prova);
			} else {
				manager.persist(prova);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean delete(Long id) {
		Prova prova = findById(id);
		try {
			manager.remove(prova);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
}
