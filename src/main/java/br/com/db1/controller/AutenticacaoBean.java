package br.com.db1.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.db1.dao.impl.AutenticacaoDao;

import br.com.db1.model.Usuario;

@ManagedBean
@RequestScoped
@Named
public class AutenticacaoBean {
	private String usuario;
	
	private String senha;

	@Inject
	private AutenticacaoDao dao;

	public String autentica() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Usuario usuarioLogado = dao.findById(this.usuario, this.senha);

		if (usuarioLogado == null) {
			FacesMessage fm = new FacesMessage("usuário e/ou senha inválidos");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(null, fm);
			return "/login";
		} else if (usuarioLogado.getAdministrador()) {

			ExternalContext ec = fc.getExternalContext();
			HttpSession session = (HttpSession) ec.getSession(false);
			session.setAttribute("usuario", usuarioLogado);

			return "/avaliador/home";
			
		}else if (usuarioLogado.getAdministrador().equals(false)){

			ExternalContext ec = fc.getExternalContext();
			HttpSession session = (HttpSession) ec.getSession(false);
			session.setAttribute("usuario", usuarioLogado);

			return "/logado/home?faces-redirect=true";

		} else {
			FacesMessage fm = new FacesMessage("usuário e/ou senha inválidos");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(null, fm);
			return "/login";
		}

	}

	public String registraSaida() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		session.removeAttribute("usuario");

		return "/login";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

