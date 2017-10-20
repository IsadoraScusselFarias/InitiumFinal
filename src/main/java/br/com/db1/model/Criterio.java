package br.com.db1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="criterio",schema="public")
public class Criterio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String descricao;
	
	private Boolean obrigatorio;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "avaliacao_id", nullable = false)
//	private Avaliacao avaliacao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getObrigatorio() {
		return obrigatorio;
	}

	public void setObrigatorio(Boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}
	
	
	


}
