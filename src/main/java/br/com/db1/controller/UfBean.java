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

import br.com.db1.dao.impl.UfDao;
import br.com.db1.model.Uf;

@ApplicationScoped
@Named
public class UfBean {

	@Inject
	private UfDao dao;

	private List<Uf> list;

	private String nomeUfFiltrada;

	private Uf uf;

	@PostConstruct
	public void init() {
		zerarLista();
	}

	private void zerarLista() {
		list = new ArrayList<Uf>();
	}

	public String getNomeUfFiltrada() {
		return nomeUfFiltrada;
	}

	public void setNomeUfFiltrada(String nomeUfFiltrada) {
		this.nomeUfFiltrada = nomeUfFiltrada;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public List<Uf> getList() {
		return list;
	}

	public String novo() {
		this.uf = new Uf();
		return "cadastrarUf";
	}

	public String salvar() {
		if (!dao.save(this.uf)) {
			adicionarMensagem("Erro ao cadastrar a UF.", FacesMessage.SEVERITY_ERROR);
		} else {
			adicionarMensagem("UF salvo com sucesso.", FacesMessage.SEVERITY_INFO);
			nomeUfFiltrada = this.uf.getNome();
			listarUf();
		}
		return "uf";
	}

	public String editar(Uf uf) {
		this.uf = dao.findById(uf.getId());
		return "cadastrarUf";
	}

	public String remover(Uf uf) {
		if (!dao.delete(uf.getId())) {
			adicionarMensagem("Erro ao remover a UF.", FacesMessage.SEVERITY_ERROR);
		} else {
			adicionarMensagem("UF removida com sucesso.", FacesMessage.SEVERITY_INFO);
			listarUf();
		}
		return "uf";
	}

	public void listarUf() {
		zerarLista();
		if (!nomeUfFiltrada.isEmpty()) {
			list.addAll(dao.findByName(nomeUfFiltrada));
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
