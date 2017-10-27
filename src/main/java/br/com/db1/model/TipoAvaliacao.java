package br.com.db1.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipoAvaliacao", schema = "public")
public class TipoAvaliacao implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20, nullable = false)
	private String nome;

	@Column(length = 2, nullable = false)
	private Integer prazoPadrao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoAvaliacao")
	private List<Criterio> criterio;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoAvaliacao")
	private List<Usuario> usuario;
	@OneToMany(fetch = FetchType.LAZY, mappedBy="tipoAvaliacao")
	private List<Prova> prova;

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public List<Criterio> getCriterio() {
		return criterio;
	}

	public void setCriterio(List<Criterio> criterio) {
		this.criterio = criterio;
	}

	public Integer getPrazoPadrao() {
		return prazoPadrao;
	}

	public void setPrazoPadrao(Integer prazoPadrao) {
		this.prazoPadrao = prazoPadrao;
	}

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
	

	public List<Prova> getProva() {
		return prova;
	}

	public void setProva(List<Prova> prova) {
		this.prova = prova;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((criterio == null) ? 0 : criterio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((prazoPadrao == null) ? 0 : prazoPadrao.hashCode());
		result = prime * result + ((prova == null) ? 0 : prova.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TipoAvaliacao))
			return false;
		TipoAvaliacao other = (TipoAvaliacao) obj;
		if (criterio == null) {
			if (other.criterio != null)
				return false;
		} else if (!criterio.equals(other.criterio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (prazoPadrao == null) {
			if (other.prazoPadrao != null)
				return false;
		} else if (!prazoPadrao.equals(other.prazoPadrao))
			return false;
		if (prova == null) {
			if (other.prova != null)
				return false;
		} else if (!prova.equals(other.prova))
			return false;
		return true;
	}



}