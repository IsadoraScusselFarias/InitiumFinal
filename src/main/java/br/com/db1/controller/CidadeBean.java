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

import br.com.db1.dao.impl.CidadeDao;
import br.com.db1.dao.impl.UfDao;
import br.com.db1.model.Cidade;
import br.com.db1.model.Uf;

@ApplicationScoped
@Named
public class CidadeBean {

	@Inject
	private CidadeDao dao;

	@Inject
	private UfDao ufDao;

	private List<Cidade> list;

	private List<Uf> listUf;

	private String nomeCidadeFiltrada;

	private Cidade cidade;

	@PostConstruct
	public void init() {
		zerarLista();
		carregarUf();
	}

	private void carregarUf() {
		listUf = ufDao.findAll();
	}

	private void zerarLista() {
		list = new ArrayList<Cidade>();
	}

	public List<Uf> getListUf() {
		return listUf;
	}

	public void setListUf(List<Uf> listUf) {
		this.listUf = listUf;
	}

	public String getNomeCidadeFiltrada() {
		return nomeCidadeFiltrada;
	}

	public void setNomeCidadeFiltrada(String nomeCidadeFiltrada) {
		this.nomeCidadeFiltrada = nomeCidadeFiltrada;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getList() {
		return list;
	}

	public void setList(List<Cidade> list) {
		this.list = list;
	}

	public String novo() {
		this.cidade = new Cidade();
		return "cadastrarCidade";
	}

	public String salvar() {
		if (!dao.save(this.cidade)) {
			adicionarMensagem("Erro ao cadastrar a cidade.", FacesMessage.SEVERITY_ERROR);
		} else {
			adicionarMensagem("Cidade salvo com sucesso.", FacesMessage.SEVERITY_INFO);
			nomeCidadeFiltrada = this.cidade.getNome();
			listarCidade();
		}
		return "cidade";
	}

	public String editar(Cidade cidade) {
		this.cidade = dao.findById(cidade.getId());
		return "cadastrarCidade";
	}

	public String remover(Cidade cidade) {
		if (!dao.delete(cidade.getId())) {
			adicionarMensagem("Erro ao remover a cidade.", FacesMessage.SEVERITY_ERROR);
		} else {
			adicionarMensagem("Cidade removida com sucesso.", FacesMessage.SEVERITY_INFO);
			listarCidade();
		}
		return "cidade";
	}

	public void listarCidade() {
		zerarLista();
		if (!nomeCidadeFiltrada.isEmpty()) {
			list.addAll(dao.findByName(nomeCidadeFiltrada));
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
