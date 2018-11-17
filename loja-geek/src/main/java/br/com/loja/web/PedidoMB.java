package br.com.loja.web;


import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.loja.dao.FormaDePagamentoDAO;
import br.com.loja.modelos.Estado;
import br.com.loja.modelos.FormaDePagamento;
import br.com.loja.modelos.Pedido;

@ManagedBean
public class PedidoMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Calendar data;
	private String logradouro, numero, complemento, CEP, bairro, cidade, numeroCartao, codigoSeguranca, validade, nomeTitular;
	private Estado estado;
	
	FormaDePagamento formaDePagamento = new FormaDePagamento();

	private Pedido pedido;
	
	public PedidoMB() {
		System.out.println("a");
		if (this.pedido == null) {
			this.pedido = new Pedido();	
		}
	}
	
	public Pedido getPedido() {
		System.out.println("b");
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		System.out.println("c");
		this.pedido = pedido;
	}
	
	public FormaDePagamento getFormaDePagamento() {
		System.out.println("7");
		return formaDePagamento;
	}
	
	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		System.out.println("8");
		this.formaDePagamento = formaDePagamento;
	}
	
	public Calendar getData() {
		System.out.println("d");
		return data;
	}

	public void setData(Calendar data) {
		System.out.println("e");
		this.data = data;
	}

	public String getLogradouro() {
		System.out.println("f");
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		System.out.println("g");
		this.logradouro = logradouro;
	}

	public String getNumero() {
		System.out.println("h");
		return numero;
	}

	public void setNumero(String numero) {
		System.out.println("i");
		this.numero = numero;
	}

	public String getComplemento() {
		System.out.println("j");
		return complemento;
	}

	public void setComplemento(String complemento) {
		System.out.println("k");
		this.complemento = complemento;
	}

	public String getCEP() {
		System.out.println("l");
		return CEP;
	}

	public void setCEP(String cEP) {
		System.out.println("m");
		CEP = cEP;
	}

	public String getBairro() {
		System.out.println("n");
		return bairro;
	}

	public void setBairro(String bairro) {
		System.out.println("o");
		this.bairro = bairro;
	}

	public String getCidade() {
		System.out.println("p");
		return cidade;
	}

	public void setCidade(String cidade) {
		System.out.println("q");
		this.cidade = cidade;
	}

	public String getNumeroCartao() {
		System.out.println("r");
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		System.out.println("s");
		this.numeroCartao = numeroCartao;
	}

	public String getCodigoSeguranca() {
		System.out.println("t");
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(String codigoSeguranca) {
		System.out.println("u");
		this.codigoSeguranca = codigoSeguranca;
	}

	public String getValidade() {
		System.out.println("v");
		return validade;
	}

	public void setValidade(String validade) {
		System.out.println("w");
		this.validade = validade;
	}

	public String getNomeTitular() {
		System.out.println("x");
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		System.out.println("y");
		this.nomeTitular = nomeTitular;
	}

	public Estado getEstado() {
		System.out.println("z");
		return estado;
	}

	public void setEstado(Estado estado) {
		System.out.println("0");
		this.estado = estado;
	}

	public void save() throws IOException {
		System.out.println("1");
		FormaDePagamento formaDePagamento = new FormaDePagamento();
		FormaDePagamentoDAO formaDePagamentoDAO = new FormaDePagamentoDAO();
		
		if(numeroCartao.isEmpty()) {
			System.out.println("2");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Número do cartão inválido",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		if(nomeTitular.isEmpty()) {
			System.out.println("3");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nome do titular do cartão inválido",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		if(validade.isEmpty()) {
			System.out.println("4");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Validade do cartão inválida",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
			
		if(codigoSeguranca.isEmpty()) {
			System.out.println("5");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Código de segurança inválido",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		//teste
		System.out.println(numeroCartao);
		System.out.println(nomeTitular);
		System.out.println(validade);
		System.out.println(codigoSeguranca);
		formaDePagamento.setNumeroCartao(numeroCartao);
		formaDePagamento.setNomeTitular(nomeTitular);
		formaDePagamento.setValidade(validade);
		formaDePagamento.setCodigoSeguranca(codigoSeguranca);
	
		System.out.println("6");
		formaDePagamentoDAO.inserir(formaDePagamento);
	}	
} 