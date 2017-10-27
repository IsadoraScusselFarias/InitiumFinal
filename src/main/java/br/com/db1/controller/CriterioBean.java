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

import br.com.db1.dao.impl.CriterioDao;
import br.com.db1.dao.impl.TipoAvaliacaoDao;
import br.com.db1.model.Cidade;
import br.com.db1.model.Criterio;
import br.com.db1.model.TipoAvaliacao;

@ApplicationScoped
@Named
public class CriterioBean {

	@Inject
	private CriterioDao dao;

	/* ************************************** */
	@Inject
	private TipoAvaliacaoDao tipoAvaliacaoDao;


	private List<TipoAvaliacao> listTipoAvaliacao;

	/* ************************************** */

	private List<Criterio> list;
	private String descricaoCriterioFiltrado;
	private Criterio criterio;



	public CriterioDao getDao() {
		return dao;
	}
	public void setDao(CriterioDao dao) {
		this.dao = dao;
	}


	public TipoAvaliacaoDao getTipoAvaliacaoDao() {
		return tipoAvaliacaoDao;
	}
	public void setTipoAvaliacaoDao(TipoAvaliacaoDao tipoAvaliacaoDao) {
		this.tipoAvaliacaoDao = tipoAvaliacaoDao;
	}

	public List<TipoAvaliacao> getListTipoAvaliacao() {
		return listTipoAvaliacao;
	}
	public void setListTipoAvaliacao(List<TipoAvaliacao> listTipoAvaliacao) {
		this.listTipoAvaliacao = listTipoAvaliacao;
	}


	@PostConstruct
	public void init() {
		zerarLista();
		zerarListaTipoAvaliacao();
		carregarTipoAvaliacao();
		criterio = new Criterio();
	}

	private void carregarTipoAvaliacao() {
		listTipoAvaliacao = tipoAvaliacaoDao.findAll();
	}

	private void zerarListaTipoAvaliacao() {
		listTipoAvaliacao = new ArrayList<TipoAvaliacao>();
	}

	/* ***************************************** */
	public List<Criterio> getList() {
		return list;
	}

	public void setList(List<Criterio> list) {
		this.list = list;
	}

	public String getDescricaoCriterioFiltrado() {
		return descricaoCriterioFiltrado;
	}

	public void setDescricaoCriterioFiltrado(String descricaoCriterioFiltrado) {
		this.descricaoCriterioFiltrado = descricaoCriterioFiltrado;
	}

	public Criterio getCriterio() {
		return criterio;
	}

	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}


	private void zerarLista() {
		list = new ArrayList<Criterio>();
	}

	public String novo() {
		this.criterio= new Criterio();
		return "cadastrarCriterio";
	}
	public String salvar() {
		if (!dao.save(this.criterio)) {
			adicionarMensagem("Erro ao cadastrar o criterio.", FacesMessage.SEVERITY_ERROR);
		} else {
			adicionarMensagem("Criterio salvo com sucesso.", FacesMessage.SEVERITY_INFO);
			descricaoCriterioFiltrado = this.criterio.getDescricao();
			listarCriterio();
		}
		return "criterio";
	}

	public String editar(Criterio criterio) {
		this.criterio = dao.findById(criterio.getId());
		return "cadastrarCriterio";
	}

	public String remover(Criterio criterio) {
		if (!dao.delete(criterio.getId())) {
			adicionarMensagem("Erro ao remover o criterio .", FacesMessage.SEVERITY_ERROR);
		} else {
			adicionarMensagem("Criterio removido com sucesso.", FacesMessage.SEVERITY_INFO);
			listarCriterio();
		}
		return "criterio";
	}

	public void listarCriterio() {
		zerarLista();
		if (!descricaoCriterioFiltrado.isEmpty()) {
			list.addAll(dao.findByName(descricaoCriterioFiltrado));
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
