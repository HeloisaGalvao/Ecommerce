package br.com.loja.web;


import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.loja.dao.ClienteDAO;
import br.com.loja.interfaces.EntidadeIN;
import br.com.loja.modelos.Cliente;
import br.com.loja.regras.ValidarCPF;

@ManagedBean
public class ClienteMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String re_senha, nomeCliente, cpf, senha, email;
	private Cliente cliente;
	
	public ClienteMB() {
		if (this.cliente == null) {
			this.cliente = new Cliente();	
		}
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getRe_senha() {
		return re_senha;
	}
	public void setRe_senha(String re_senha) {
		this.re_senha = re_senha;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String cancelar(){
		return "index.xhtml?faces-redirect=true";
	}
	public void cadastra() throws IOException {
		 FacesContext.getCurrentInstance().getExternalContext().redirect("cadastro.xhtml");
	}
	
	public void save() throws IOException {
		ClienteDAO clienteDAO = new ClienteDAO();

		String CPFMask = cpf.replaceAll("\\D", "");

		//Validar se CPF é valido
		if(ValidarCPF.isCPF(CPFMask)==true){
			
			//validar se o cpf ja esta cadastrado
			EntidadeIN validaCliente = clienteDAO.consultarPorChavePrimaria(Cliente.class, CPFMask);
			if(validaCliente == null){
				
				//valdiar se e-mail ja esta cadastrado
				List<Cliente> existe = clienteDAO.getEmailVerifica(email);
				if(existe.isEmpty()) {
					Cliente cliente = new Cliente();
					cliente.setNomeCliente(nomeCliente);
					cliente.setEmail(email);
					cliente.setSenha(senha);
					cliente.setCpf(CPFMask);

					clienteDAO.inserir(cliente);

					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("Successful",  "Seja bem vindo(a) " + cliente.getNomeCliente()));

				}else{
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"E-mail ja cadastrado",null);
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			}else{
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Cliente ja cadstrado",null);
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}else{
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"CPF invalido",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
} 