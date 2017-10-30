package br.com.db1.model;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario", schema = "public")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(length = 50, nullable = false)
	private String email;

	@Column(length = 50)
	private byte[] senha;

	@Column()
	private Boolean administrador = false;

	@Column(nullable = false)
	private Boolean statusUsuario = false;

	@Column(nullable = true)
	private byte[] foto;
	
	@Column(name = "nomeArquivo", nullable = true, length = 50)
	private String nomeArquivo;

	@Column(name = "extensao", nullable = true, length = 10)
	private String extensaoArquivo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipoAvaliacao_id")
	private TipoAvaliacao tipoAvaliacao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<Prova> prova;

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

	public Boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}

	public Boolean getStatusUsuario() {
		return statusUsuario;
	}

	public void setStatusUsuario(Boolean statusUsuario) {
		this.statusUsuario = statusUsuario;
	}
	
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] arquivoByte) {
		this.foto = arquivoByte;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getExtensaoArquivo() {
		return extensaoArquivo;
	}

	public void setExtensaoArquivo(String extensaoArquivo) {
		this.extensaoArquivo = extensaoArquivo;
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
		result = prime * result + ((administrador == null) ? 0 : administrador.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((extensaoArquivo == null) ? 0 : extensaoArquivo.hashCode());
		result = prime * result + Arrays.hashCode(foto);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeArquivo == null) ? 0 : nomeArquivo.hashCode());
		result = prime * result + ((prova == null) ? 0 : prova.hashCode());
		result = prime * result + Arrays.hashCode(senha);
		result = prime * result + ((statusUsuario == null) ? 0 : statusUsuario.hashCode());
		result = prime * result + ((tipoAvaliacao == null) ? 0 : tipoAvaliacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (administrador == null) {
			if (other.administrador != null)
				return false;
		} else if (!administrador.equals(other.administrador))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (extensaoArquivo == null) {
			if (other.extensaoArquivo != null)
				return false;
		} else if (!extensaoArquivo.equals(other.extensaoArquivo))
			return false;
		if (!Arrays.equals(foto, other.foto))
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
		if (nomeArquivo == null) {
			if (other.nomeArquivo != null)
				return false;
		} else if (!nomeArquivo.equals(other.nomeArquivo))
			return false;
		if (prova == null) {
			if (other.prova != null)
				return false;
		} else if (!prova.equals(other.prova))
			return false;
		if (!Arrays.equals(senha, other.senha))
			return false;
		if (statusUsuario == null) {
			if (other.statusUsuario != null)
				return false;
		} else if (!statusUsuario.equals(other.statusUsuario))
			return false;
		if (tipoAvaliacao == null) {
			if (other.tipoAvaliacao != null)
				return false;
		} else if (!tipoAvaliacao.equals(other.tipoAvaliacao))
			return false;
		return true;
	}

	
	

	
}
