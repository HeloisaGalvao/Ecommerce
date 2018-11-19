package br.com.loja.web;


import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.loja.dao.FormaDePagamentoDAO;
import br.com.loja.dao.PedidoDAO;
import br.com.loja.modelos.Estado;
import br.com.loja.modelos.FormaDePagamento;
import br.com.loja.modelos.Pedido;

@ManagedBean
@ViewScoped
public class PedidoMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Calendar data;
	private String logradouro, numero, complemento, CEP, bairro, cidade, numeroCartao, codigoSeguranca, validade, nomeTitular;
	private Estado estado;
	
	FormaDePagamento formaDePagamento = new FormaDePagamento();

	private Pedido pedido;
	
	public PedidoMB() {
		if (this.pedido == null) {
			this.pedido = new Pedido();	
		}
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}
	
	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	
	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void save() throws IOException {
		FormaDePagamento formaDePagamento = new FormaDePagamento();
		FormaDePagamentoDAO formaDePagamentoDAO = new FormaDePagamentoDAO();
		Pedido pedido = new Pedido();
		PedidoDAO pedidoDAO = new PedidoDAO();
		
		if(logradouro.isEmpty()) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Endereço invalido",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		if(bairro.isEmpty()) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Bairro invalido",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		if(estado == null) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"UF invalido",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		if(cidade.isEmpty()) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Cidade invalido",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		if(CEP.isEmpty()) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"CEP invalido",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		if(numeroCartao.isEmpty()) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Número do cartão inválido",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		if(nomeTitular.isEmpty()) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nome do titular do cartão inválido",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		if(validade.isEmpty()) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Validade do cartão inválida",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
			
		if(codigoSeguranca.isEmpty()) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Código de segurança inválido",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		
		formaDePagamento.setNumeroCartao(numeroCartao);
		formaDePagamento.setNomeTitular(nomeTitular);
		formaDePagamento.setValidade(validade);
		formaDePagamento.setCodigoSeguranca(codigoSeguranca);
		pedido.setLogradouro(logradouro);
		pedido.setNumero(numero);
		pedido.setBairro(bairro);
		pedido.setCidade(cidade);
		pedido.setEstado(estado);
		pedido.setComplemento(complemento);
		pedido.setCEP(CEP);
		
		pedidoDAO.inserir(pedido);
		formaDePagamentoDAO.inserir(formaDePagamento);
		
	}	
} 