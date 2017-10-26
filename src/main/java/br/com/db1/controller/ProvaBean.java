package br.com.db1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.Id;
import javax.inject.Named;

import br.com.db1.dao.impl.ProvaDao;
import br.com.db1.model.Prova;


@ApplicationScoped
@Named
public class ProvaBean {
	@Inject
	private ProvaDao dao;
	
//	/* ************************************** */
//	@Inject
//	private TipoAvaliacaoDao tipoAvaliacaoDao;
//	conection
//	
//	private List<TipoAvaliacao> listTipoAvaliacao;
//	
//	/* ************************************** */
	
	
	private List<Prova> list;
	private String parecerProvaFiltrada;
	private Prova prova;
	
	
	
	
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
//		zerarListaTipoAvaliacao();
//		carregarTipoAvaliacao();
	}
	
//	private void carregarTipoAvaliacao() {
//		listTipoAvaliacao = tipoAvaliacaoDao.findAll();
//	}
//
//	private void zerarListaTipoAvaliacao() {
//		listTipoAvaliacao = new ArrayList<TipoAvaliacao>();
//	}
	
	private void zerarLista() {
		list = new ArrayList<Prova>();
	}
	
	public String novo() {
		this.prova= new Prova();
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
		if (!parecerProvaFiltrada.isEmpty()) {
			list.addAll(dao.findByName(parecerProvaFiltrada));
		} else {
			list.addAll(dao.findAll());
		}
	}

	public void adicionarMensagem(String mensagem, Severity tipoMensagem) {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage fm = new FacesMessage(mensagem);
		fm.setSeverity(tipoMensagem);
		fc.addMessage(null, fm);

	}

}
