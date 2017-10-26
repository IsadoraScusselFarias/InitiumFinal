package br.com.db1.model;

import java.io.Serializable;
import java.util.Date;
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
public class Prova implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String dataInicioCorrecao;
	
	@Column(nullable = false, length = 50)
	private String dataFinalCorrecao;
	
	@Column
	private String pontosFortes;
	
	@Column
	private String pontosFracos;
	
	@Column
	private String parecer;
	
	@Column
	private byte[] anexo;
	
	@Column
	private Integer prazo;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "avaliacao_id", nullable = false)
//	private Avaliacao avaliacao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataInicioCorrecao() {
		return dataInicioCorrecao;
	}

	public void setDataInicioCorrecao(String dataInicioCorrecao) {
		this.dataInicioCorrecao = dataInicioCorrecao;
	}

	public String getDataFinalCorrecao() {
		return dataFinalCorrecao;
	}

	public void setDataFinalCorrecao(String dataFinalCorrecao) {
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

	public byte[] getAnexo() {
		return anexo;
	}

	public void setAnexo(byte[] anexo) {
		this.anexo = anexo;
	}

	public Integer getPrazo() {
		return prazo;
	}

	public void setPrazo(Integer prazo) {
		this.prazo = prazo;
	}
	
	
}
