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
import javax.transaction.Transactional;

import br.com.db1.dao.impl.TipoAvaliacaoDao;
import br.com.db1.model.TipoAvaliacao;

@ApplicationScoped
@Named
public class TipoAvaliacaoBean {

	@Inject
	private TipoAvaliacaoDao dao;

	private List<TipoAvaliacao> list;

	private String nomeTipoAvaliacaoFiltrada;

	private TipoAvaliacao tipoAvaliacao;

	@PostConstruct
	public void init() {
		zerarLista();
	}

	private void zerarLista() {
		list = new ArrayList<TipoAvaliacao>();
	}

	public String getNomeTipoAvaliacaoFiltrada() {
		return nomeTipoAvaliacaoFiltrada;
	}

	public void setNomeTipoAvaliacaoFiltrada(String nomeTipoAvaliacaoFiltrada) {
		this.nomeTipoAvaliacaoFiltrada = nomeTipoAvaliacaoFiltrada;
	}

	public TipoAvaliacao getTipoAvaliacao() {
		return tipoAvaliacao;
	}

	public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
	}

	public List<TipoAvaliacao> getList() {
		return list;
	}

	public String novo() {
		this.tipoAvaliacao = new TipoAvaliacao();
		return "cadastrarTipoAvaliacao";
	}
	@Transactional
	public String salvar() {
		if (!dao.save(this.tipoAvaliacao)) {
			adicionarMensagem("Erro ao cadastrar o tipo de avaliacao.", FacesMessage.SEVERITY_ERROR);
		} else {
			adicionarMensagem("Tipo de avaliacao salvo com sucesso.", FacesMessage.SEVERITY_INFO);
			nomeTipoAvaliacaoFiltrada = this.tipoAvaliacao.getNome();
			listarTipoAvaliacao();
		}
		return "tipoAvaliacao";
	}

	public String editar(TipoAvaliacao tipoAvaliacao) {
		this.tipoAvaliacao = dao.findById(tipoAvaliacao.getId());
		return "cadastrarTipoAvaliacao";
	}

	public String remover(TipoAvaliacao tipoAvaliacao) {
		if (!dao.delete(tipoAvaliacao.getId())) {
			adicionarMensagem("Erro ao remover o tipo de avaliacao.", FacesMessage.SEVERITY_ERROR);
		} else {
			adicionarMensagem("Tipo de avaliacao removido com sucesso.", FacesMessage.SEVERITY_INFO);
			listarTipoAvaliacao();
		}
		return "tipoAvaliacao";
	}

	public void listarTipoAvaliacao() {
		zerarLista();
		if (!nomeTipoAvaliacaoFiltrada.isEmpty()) {
			list.addAll(dao.findByName(nomeTipoAvaliacaoFiltrada));
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