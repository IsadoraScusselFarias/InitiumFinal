
package br.com.db1.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.db1.dao.DAO;
import br.com.db1.dao.Transactional;
import br.com.db1.model.TipoAvaliacao;

public class TipoAvaliacaoDao implements DAO<TipoAvaliacao> {

	@Inject
	private EntityManager manager;

	public List<TipoAvaliacao> findAll() {
		return manager.createQuery("Select u from TipoAvaliacao u").getResultList();
	}

	public TipoAvaliacao findById(Long id) {
		Query query = manager.createQuery("Select u from TipoAvaliacao u where u.id = :pId");
		query.setParameter("pId", id);
		return (TipoAvaliacao) query.getSingleResult();
	}

	public List<TipoAvaliacao> findByName(String nome) {
		Query query = manager.createQuery("Select u from TipoAvaliacao u where u.nome like :pNome");
		query.setParameter("pNome", "%"+nome+"%");
		return query.getResultList();
	}

	@Transactional
	public boolean save(TipoAvaliacao tipoAvaliacao) {
		try {
			if (tipoAvaliacao.getId() != null) {
				manager.merge(tipoAvaliacao);
			} else {
				manager.persist(tipoAvaliacao);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean delete(Long id) {
		TipoAvaliacao tipoAvaliacao = findById(id);
		try {
			manager.remove(tipoAvaliacao);
		} catch (Exception e) {
			return false;
		}
		return true;

	}


}