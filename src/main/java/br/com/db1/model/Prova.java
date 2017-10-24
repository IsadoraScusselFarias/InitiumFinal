package br.com.db1.model;

import java.sql.Date;
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
@Table(name = "prova", schema = "public")
public class Prova {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Date dataInicioCorrecao;
	@Column
	private Date dataFinalCorrecao;
	@Column
	private String pontosFortes;
	@Column
	private String pontosFracos;
	@Column
	private String parecer;
	@Column
	private String blob;
	@Column
	private Integer Prazo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prova")
	private List<TipoAvaliacao> avaliacoes;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prova")
//	private List<Usuario> usuarios;
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prova")
//	private List<Candidato> candidatos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataInicioCorrecao() {
		return dataInicioCorrecao;
	}

	public void setDataInicioCorrecao(Date dataInicioCorrecao) {
		this.dataInicioCorrecao = dataInicioCorrecao;
	}

	public Date getDataFinalCorrecao() {
		return dataFinalCorrecao;
	}

	public void setDataFinalCorrecao(Date dataFinalCorrecao) {
		this.dataFinalCorrecao = dataFinalCorrecao;
	}

	public String getPontosFortes() {
		return pontosFortes;
	}

	public void setPontosFortes(String pontosFortes) {
		this.pontosFortes = pontosFortes;
	}

	public String getPontosFracos() {
		return pontosFracos;
	}

	public void setPontosFracos(String pontosFracos) {
		this.pontosFracos = pontosFracos;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public String getBlob() {
		return blob;
	}

	public void setBlob(String blob) {
		this.blob = blob;
	}

	public Integer getPrazo() {
		return Prazo;
	}

	public void setPrazo(Integer prazo) {
		Prazo = prazo;
	}

	public List<TipoAvaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<TipoAvaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

//	public List<Usuario> getUsuarios() {
//		return usuarios;
//	}
//
//	public void setUsuarios(List<Usuario> usuarios) {
//		this.usuarios = usuarios;
//	}
//
//	public List<Candidato> getCandidatos() {
//		return candidatos;
//	}
//
//	public void setCandidatos(List<Candidato> candidatos) {
//		this.candidatos = candidatos;
//	}

}
