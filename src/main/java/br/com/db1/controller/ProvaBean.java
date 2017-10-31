package br.com.db1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import br.com.db1.dao.impl.CandidatoDao;
import br.com.db1.dao.impl.ProvaDao;
import br.com.db1.dao.impl.TipoAvaliacaoDao;
import br.com.db1.dao.impl.UsuarioDao;
import br.com.db1.model.Candidato;
import br.com.db1.model.Prova;
import br.com.db1.model.TipoAvaliacao;
import br.com.db1.model.Usuario;

@ApplicationScoped
@Named
public class ProvaBean {
	@Inject
	private ProvaDao dao;

	/* ************************************** */
	@Inject
	private TipoAvaliacaoDao tipoAvaliacaoDao;

	private List<TipoAvaliacao> listTipoAvaliacao;

	/* ************************************** */
	
	/* ************************************** */
	@Inject
	private ProvaDao provaDao;

	private List<Prova> listProva;

	/* ************************************** */
	
	/* ************************************** */
	@Inject
	private CandidatoDao candidatoDao;


	private List<Candidato> listCandidato;

	/* ************************************** */
	
	/* ************************************** */
	@Inject
	private UsuarioDao usuarioDao;


	private List<Usuario> listUsuario;

	/* ************************************** */


	private List<Prova> list;
	private String parecerProvaFiltrada;
	private Prova prova;
	private Part arquivoUpado;
	private String nomeArquivoFiltrado;
	
	public ProvaDao getDao() {
		return dao;
	}

	public void setDao(ProvaDao dao) {
		this.dao = dao;
	}

	public List<Prova> getList() {
		return list;
	}

	public void setList(List<Prova> list) {
		this.list = list;
	}

	public String getParecerProvaFiltrada() {
		return parecerProvaFiltrada;
	}

	public void setParecerProvaFiltrada(String parecerProvaFiltrada) {
		this.parecerProvaFiltrada = parecerProvaFiltrada;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	@PostConstruct
	public void init() {
		zerarLista();
		this.prova = new Prova();
		zerarListaTipoAvaliacao();
		carregarTipoAvaliacao();
		zerarListaCandidato();
		carregarCandidato();
		zerarListaUsuario();
		carregarUsuario();
		zerarListaTipoAvaliacao();
		carregarTipoAvaliacao();

	}
	
	

	
	public ProvaDao getProvaDao() {
		return provaDao;
	}

	public void setProvaDao(ProvaDao provaDao) {
		this.provaDao = provaDao;
	}

	public List<Prova> getListProva() {
		return listProva;
	}

	public void setListProva(List<Prova> listProva) {
		this.listProva = listProva;
	}

	private void carregarTipoAvaliacao() {
		setListTipoAvaliacao(getTipoAvaliacaoDao().findAll());
	}

	private void zerarListaTipoAvaliacao() {
		setListTipoAvaliacao(new ArrayList<TipoAvaliacao>());
	}
	
	private void carregarProva() {
		setListProva(getProvaDao().findAll());
	}

	private void zerarProva() {
		setListProva(new ArrayList<Prova>());
	}
	
	private void carregarCandidato() {
		setListCandidato(getCandidatoDao().findAll());
	}

	private void zerarListaCandidato() {
		setListCandidato(new ArrayList<Candidato>());
	}
	
	private void carregarUsuario() {
		setListUsuario(getUsuarioDao().findAll());
	}

	private void zerarListaUsuario() {
		setListUsuario(new ArrayList<Usuario>());
	}

	private void zerarLista() {
		list = new ArrayList<Prova>();
	}

	public String novo() {
		this.prova = new Prova();
		return "cadastrarProva";
	}

	public String salvar() {
		if (!dao.save(this.prova)) {
			adicionarMensagem("Erro ao cadastrar a prova.", FacesMessage.SEVERITY_ERROR);
		} else {
			adicionarMensagem("Prova salva com sucesso.", FacesMessage.SEVERITY_INFO);
			parecerProvaFiltrada = this.prova.getParecer();
			listarProva();
		}
		return "prova";
	}

	public String editar(Prova prova) {
		this.prova = dao.findById(prova.getId());
		return "cadastrarProva";
	}

	public String remover(Prova prova) {
		if (!dao.delete(prova.getId())) {
			adicionarMensagem("Erro ao remover a prova .", FacesMessage.SEVERITY_ERROR);
		} else {
			adicionarMensagem("Prova removida com sucesso.", FacesMessage.SEVERITY_INFO);
			listarProva();
		}
		return "prova";
	}

	public void listarProva() {
		zerarLista();
		if (parecerProvaFiltrada != null && !parecerProvaFiltrada.isEmpty()) {
			list.addAll(dao.findByName(parecerProvaFiltrada));
		} else {
			list.addAll(dao.findAll());
		}
	}
	
	/* ********************************************************** */
	public void listarProvaAvaliador() {
		zerarLista();
		if (parecerProvaFiltrada != null && !parecerProvaFiltrada.isEmpty()) {
			list.addAll(dao.findByNameAvaliador(parecerProvaFiltrada));
		} else {
			list.addAll(dao.findAllAvaliador());
		}
	}
	/* *************************************************************** */

	public void adicionarMensagem(String mensagem, Severity tipoMensagem) {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage fm = new FacesMessage(mensagem);
		fm.setSeverity(tipoMensagem);
		fc.addMessage(null, fm);

	}

	public List<TipoAvaliacao> getListTipoAvaliacao() {
		return listTipoAvaliacao;
	}

	public void setListTipoAvaliacao(List<TipoAvaliacao> listTipoAvaliacao) {
		this.listTipoAvaliacao = listTipoAvaliacao;
	}

	public TipoAvaliacaoDao getTipoAvaliacaoDao() {
		return tipoAvaliacaoDao;
	}

	public void setTipoAvaliacaoDao(TipoAvaliacaoDao tipoAvaliacaoDao) {
		this.tipoAvaliacaoDao = tipoAvaliacaoDao;
	}
	public CandidatoDao getCandidatoDao() {
		return candidatoDao;
	}

	public void setCandidatoDao(CandidatoDao candidatoDao) {
		this.candidatoDao = candidatoDao;
	}

	public List<Candidato> getListCandidato() {
		return listCandidato;
	}

	public void setListCandidato(List<Candidato> listCandidato) {
		this.listCandidato = listCandidato;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public List<Usuario> getListUsuario() {
		return listUsuario;
	}

	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}
	public String getNomeArquivoFiltrado() {
		return nomeArquivoFiltrado;
	}

	public void setNomeArquivoFiltrado(String nomeArquivoFiltrado) {
		this.nomeArquivoFiltrado = nomeArquivoFiltrado;
	}

	public Part getArquivoUpado() {
		return arquivoUpado;
	}

	public void setArquivoUpado(Part arquivoUpado) {
		this.arquivoUpado = arquivoUpado;
	}
}
