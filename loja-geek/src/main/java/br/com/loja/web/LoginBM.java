package br.com.loja.web;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.loja.dao.ClienteDAO;
import br.com.loja.modelos.Cliente;

@ManagedBean
public class LoginBM {
	private String login , senha ;
	private Cliente cliente;
	
	public LoginBM() {
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
	
	public void logar() throws IOException {
		ClienteDAO clienteDAO = new ClienteDAO();
		String login1 = login;
		String senha1 = senha;
		List<Cliente> existe = clienteDAO.getLoginSenha(login, senha);
		System.out.println("a");
		if(existe.equals(login) && existe.equals(senha)) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		}else {
			List<Cliente> naoExiste = clienteDAO.getLogin(login);
			if(naoExiste.isEmpty()) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Cliente não cadastrado",null);
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"login ou senha invalido",null);
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
		
	}
	
}
