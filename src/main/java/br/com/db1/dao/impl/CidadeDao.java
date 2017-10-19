package br.com.db1.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.db1.dao.DAO;
import br.com.db1.dao.Transactional;
import br.com.db1.model.Cidade;

public class CidadeDao implements DAO<Cidade> {

	@Inject
	private EntityManager manager;

	public List<Cidade> findAll() {
		return manager.createQuery("Select c from Cidade c").getResultList();
	}

	public Cidade findById(Long id) {
		Query query = manager.createQuery("Select c from Cidade c where c.id = :pId");
		query.setParameter("pId", id);
		return (Cidade) query.getSingleResult();
	}

	public List<Cidade> findByName(String nome) {
		Query query = manager.createQuery("Select c from Cidade c where c.nome like :pNome");
		query.setParameter("pNome", "%"+nome+"%");
		return query.getResultList();
	}

	@Transactional
	public boolean save(Cidade cidade) {
		try {
			if (cidade.getId() != null) {
				manager.merge(cidade);
			} else {
				manager.persist(cidade);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean delete(Long id) {
		Cidade cidade = findById(id);
		try {
			manager.remove(cidade);
		} catch (Exception e) {
			return false;
		}
		return true;

	}


}
