package br.com.db1.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prova", schema = "public")
public class Prova {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = true, length = 50)
	private String dataInicioCorrecao;
	
	@Column(nullable = true, length = 50)
	private String dataFinalCorrecao;
	
	@Column(nullable = true)
	private String pontosFortes;
	
	@Column(nullable = true)
	private String pontosFracos;
	
	@Column(nullable = true)
	private String parecer;
	
	@Column(nullable = true)
	private byte[] anexo;
	
	@Column(name = "nomeArquivo", nullable = true, length = 50)
	private String nomeArquivo;

	@Column(name = "extensao", nullable = true, length = 10)
	private String extensaoArquivo;
	
	@Column(nullable = true)
	private Integer prazo;

	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "avaliacao_id", nullable = false)
//	private Avaliacao avaliacao;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipoAvaliacao_id", nullable = true)
	private TipoAvaliacao tipoAvaliacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tbcandidato_id", nullable = true)
	private Candidato candidato;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", nullable = true)
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public TipoAvaliacao getTipoAvaliacao() {
		return tipoAvaliacao;
	}

	public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
	}
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anexo == null) ? 0 : anexo.hashCode());
		result = prime * result + ((candidato == null) ? 0 : candidato.hashCode());
		result = prime * result + ((dataFinalCorrecao == null) ? 0 : dataFinalCorrecao.hashCode());
		result = prime * result + ((dataInicioCorrecao == null) ? 0 : dataInicioCorrecao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((parecer == null) ? 0 : parecer.hashCode());
		result = prime * result + ((pontosFortes == null) ? 0 : pontosFortes.hashCode());
		result = prime * result + ((pontosFracos == null) ? 0 : pontosFracos.hashCode());
		result = prime * result + ((prazo == null) ? 0 : prazo.hashCode());
		result = prime * result + ((tipoAvaliacao == null) ? 0 : tipoAvaliacao.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Prova))
			return false;
		Prova other = (Prova) obj;
		if (anexo == null) {
			if (other.anexo != null)
				return false;
		} else if (!anexo.equals(other.anexo))
			return false;
		if (candidato == null) {
			if (other.candidato != null)
				return false;
		} else if (!candidato.equals(other.candidato))
			return false;
		if (dataFinalCorrecao == null) {
			if (other.dataFinalCorrecao != null)
				return false;
		} else if (!dataFinalCorrecao.equals(other.dataFinalCorrecao))
			return false;
		if (dataInicioCorrecao == null) {
			if (other.dataInicioCorrecao != null)
				return false;
		} else if (!dataInicioCorrecao.equals(other.dataInicioCorrecao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (parecer == null) {
			if (other.parecer != null)
				return false;
		} else if (!parecer.equals(other.parecer))
			return false;
		if (pontosFortes == null) {
			if (other.pontosFortes != null)
				return false;
		} else if (!pontosFortes.equals(other.pontosFortes))
			return false;
		if (pontosFracos == null) {
			if (other.pontosFracos != null)
				return false;
		} else if (!pontosFracos.equals(other.pontosFracos))
			return false;
		if (prazo == null) {
			if (other.prazo != null)
				return false;
		} else if (!prazo.equals(other.prazo))
			return false;
		if (tipoAvaliacao == null) {
			if (other.tipoAvaliacao != null)
				return false;
		} else if (!tipoAvaliacao.equals(other.tipoAvaliacao))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	

	
	
}
