/*package br.com.db1.dao.impl;

import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.db1.AbstractTestCase;
import br.com.db1.dao.impl.UsuarioDao;
import br.com.db1.model.Usuario;

public class UsuarioDaoTest extends AbstractTestCase {

	private UsuarioDao dao;

	@Before
	public void init() {
		dao = new UsuarioDao(manager);
	}

	@Test
	public void findAllTest() {
		Query queryCidade = manager.createNativeQuery("DELETE FROM Cidade");
		queryCidade.executeUpdate();

		Query queryUsuario = manager.createNativeQuery("DELETE FROM Usuario");
		queryUsuario.executeUpdate();
		Assert.assertTrue(dao.findAll().size() == 0);

		Usuario usuario = new Usuario();
		usuario.setNome("PP");
		manager.persist(usuario);

		Assert.assertTrue(dao.findAll().size() > 0);

	}

	@Test
	public void findByIdTest() {
		
	}

	@Test
	public void findByNameTest() {
		Query queryCidade = manager.createNativeQuery("DELETE FROM Cidade");
		queryCidade.executeUpdate();

		Query queryUsuario = manager.createNativeQuery("DELETE FROM Usuario where nome = :pNome");
		queryUsuario.setParameter("pNome", "PP");
		queryUsuario.executeUpdate();
		Assert.assertTrue(dao.findByName("PP").size() == 0);

		Usuario usuario = new Usuario();
		usuario.setNome("PP");
		manager.persist(usuario
);

		Assert.assertTrue(dao.findByName("PP").size() == 1);
	}

	@Test
	public void saveTest() {
		Query queryCidade = manager.createNativeQuery("DELETE FROM Cidade");
		queryCidade.executeUpdate();

		Query queryUsuario = manager.createNativeQuery("DELETE FROM Usuario");
		queryUsuario.executeUpdate();
		Assert.assertTrue(dao.findAll().size() == 0);

		Usuario usuario = new Usuario();
		usuario.setNome("PP");
		dao.save(usuario);

		Assert.assertTrue(dao.findAll().size() == 1);
		
		usuario.setNome("RR");
		dao.save(usuario);
		Assert.assertTrue(dao.findAll().size() == 1);


	}

	@Test
	public void deleteTest() {
		Query queryCidade = manager.createNativeQuery("DELETE FROM Cidade");
		queryCidade.executeUpdate();

		Query queryUsuario = manager.createNativeQuery("DELETE FROM Usuario");
		queryUsuario.executeUpdate();
		Assert.assertTrue(dao.findAll().size() == 0);

		Usuario usuario = new Usuario();
		usuario.setNome("PP");
		dao.save(usuario);

		Assert.assertTrue(dao.findAll().size() == 1);
		
		dao.delete(usuario.getId());
		Assert.assertTrue(dao.findAll().size() == 0);

	}

}*/