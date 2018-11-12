package br.com.loja.web;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.loja.dao.ClienteDAO;
import br.com.loja.modelos.Cliente;

@ManagedBean
public class LoginMB {
	private String login , senha ;
	private Cliente cliente;
	
	public void LoginBM() {
		if (this.cliente == null) {
			this.cliente = new Cliente();	
		}
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void cadastrar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastro.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void logar() throws IOException {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente existe = clienteDAO.getLoginSenha(login, senha);
		
		if(existe.getLogin().equals(login) && existe.getSenha().equals(senha)) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		}else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"login ou senha invalido",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}	
	}
	
}
