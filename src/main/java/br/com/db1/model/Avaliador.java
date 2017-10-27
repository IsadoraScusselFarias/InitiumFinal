package br.com.db1.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "avaliador", schema = "public")
public class Avaliador  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(length = 50, nullable = false)
	private String email;

	@Column(length = 50)
	private byte[] senha;
	

	@Column(nullable = false)
	private Boolean statusAvaliador = false;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getSenha() {
		return senha;
	}

	public void setSenha(byte[] senha) {
		this.senha = senha;
	}

	

	public Boolean getStatusAvaliador() {
		return statusAvaliador;
	}

	public void setStatusAvaliador(Boolean statusAvaliador) {
		this.statusAvaliador = statusAvaliador;
	}

	
}