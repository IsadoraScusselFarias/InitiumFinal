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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((prazoPadrao == null) ? 0 : prazoPadrao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoAvaliacao other = (TipoAvaliacao) obj;
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
		return true;
	}

}