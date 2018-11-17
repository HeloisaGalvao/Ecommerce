package br.com.loja.web;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.loja.dao.ClienteDAO;
import br.com.loja.modelos.Cliente;

@ManagedBean
public class LoginMB {
	private String email , senha ;
	private Cliente cliente;
	
	public void LoginBM() {
		if (this.cliente == null) {
			this.cliente = new Cliente();	
		}
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void cadastrar() {
		
	}
	
	public void logar() throws IOException {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente existe = clienteDAO.getEntrar(email, senha);
		
		if(existe.getEmail().equals(email) && existe.getSenha().equals(senha)) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		}else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"login ou senha invalido",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}	
	}
	
}
