package br.com.db1.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.Id;

import br.com.db1.dao.impl.ProvaDao;
import br.com.db1.model.Prova;
import br.com.db1.model.Uf;

public class ProvaBean {

	@Inject
	private ProvaDao dao;

	private List<Prova> list;

	private String nomeProvaFiltrada;

	private Prova prova;


	public List<Prova> getList() {
		return list;
	}
	public void setList(List<Prova> list) {
		this.list = list;
	}
	public String getNomeProvaFiltrada() {
		return nomeProvaFiltrada;
	}
	public void setNomeProvaFiltrada(String nomeProvaFiltrada) {
		this.nomeProvaFiltrada = nomeProvaFiltrada;
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
	}
	private void zerarLista() {
		list = new ArrayList<Prova>();
	}
	
	public String salvar() {
		if (!dao.save(this.prova)) {
			adicionarMensagem("Erro ao cadastrar a Prova.", FacesMessage.SEVERITY_ERROR);
		} else {
			adicionarMensagem("Prova salva com sucesso.", FacesMessage.SEVERITY_INFO);
			nomeProvaFiltrada = this.prova.getParecer();
			listarProva();
		}	return "prova";
	}

	public String editar(Prova prova) {
		this.prova = dao.findById(prova.getId());
		return "cadastrarProva";
	}

	public String remover(Uf uf) {
		if (!dao.delete(uf.getId())) {
			adicionarMensagem("Erro ao remover a UF.", FacesMessage.SEVERITY_ERROR);
		} else {
			adicionarMensagem("UF removida com sucesso.", FacesMessage.SEVERITY_INFO);
			listarProva();
		}
		return "uf";
	}
	
	public String remover(Prova prova) {
		if (!dao.delete(prova.getId())) {
			adicionarMensagem("Erro ao remover a Prova.", FacesMessage.SEVERITY_ERROR);
		} else {
			adicionarMensagem("Prova removida com sucesso.", FacesMessage.SEVERITY_INFO);
			listarProva();
		}
		return "uf";
	}

	
	public void listarProva() {
		zerarLista();
		if (!nomeProvaFiltrada.isEmpty()) {
			list.addAll((Collection<? extends Prova>) dao.findById(prova.getId()));
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
