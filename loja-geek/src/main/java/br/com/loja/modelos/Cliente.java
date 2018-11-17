package br.com.loja.modelos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.loja.interfaces.EntidadeIN;

@Entity
public class Cliente implements EntidadeIN  {
	
	private String nomeCliente;	
	private String email;
	private String senha;
	@Id
	@Column(name="CpfCliente", length=11)
	private String cpf;
	
	
	public Cliente() {
		
	}
	
	public Cliente(String nomeCliente, String email, String senha, String cpf) {
		this.nomeCliente = nomeCliente;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
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
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public Object getChavePrimaria() {
		return getCpf();
	}
	
}
