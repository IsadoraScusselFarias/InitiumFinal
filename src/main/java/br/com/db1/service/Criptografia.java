package br.com.db1.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {

	public byte[] criptografar(String senha, String tipoCriptografia) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance(tipoCriptografia);
			digest.update(senha.getBytes());
			return digest.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}		
		return null;
	}
}