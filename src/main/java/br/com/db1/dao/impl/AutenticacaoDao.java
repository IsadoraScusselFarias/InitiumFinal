package br.com.db1.dao.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.db1.model.Usuario;
import br.com.db1.service.Criptografia;

public class AutenticacaoDao{

	@Inject
	private EntityManager manager;

	@Inject
	private Criptografia criptografia;
	
	public Usuario findById(String usuario, String senha) {
		try {
			byte[] senhaCriptografada = criptografia.criptografar(senha, "MD5"); 
			Query query = manager.createQuery("Select p from Usuario p where p.email = :pEmail and p.senha = :pSenha");
			query.setParameter("pEmail", usuario);
			query.setParameter("pSenha", senhaCriptografada);
			return (Usuario) query.getSingleResult();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
}