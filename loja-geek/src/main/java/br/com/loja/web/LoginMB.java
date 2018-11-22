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
	private static String clienteLogado;
	private static String nomeClienteLogado;
	
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
	
	public static String getClienteLogado() {
		return clienteLogado;
	}

	public static void setClienteLogado(String clienteLogado) {
		LoginMB.clienteLogado = clienteLogado;
	}
	
	public static String getNomeClienteLogado() {
		return nomeClienteLogado;
	}

	public static void setNomeClienteLogado(String nomeClienteLogado) {
		LoginMB.nomeClienteLogado = nomeClienteLogado;
	}

	public void cadastrar() {
		
	}
	
	public void logar() throws IOException {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente existe = clienteDAO.getEntrar(email, senha);
		
		if(existe.getEmail().equals(email) && existe.getSenha().equals(senha)) {
			LoginMB.clienteLogado = existe.getCpf();
			LoginMB.nomeClienteLogado = existe.getNomeCliente();
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		}else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"login ou senha invalido",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}	
	}
	
}
