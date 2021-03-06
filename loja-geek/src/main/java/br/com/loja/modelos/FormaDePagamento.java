package br.com.loja.modelos;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.loja.interfaces.EntidadeIN;

@Entity
public class FormaDePagamento implements EntidadeIN {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPagamento;
	private BigDecimal valor;
	private String numeroCartao;
	private String codigoSeguranca;
	private String validade;
	private String nomeTitular;
	
	public FormaDePagamento() {
		
	}
	
	public FormaDePagamento(int idPagamento, BigDecimal valor, String numeroCartao,
		String codigoSeguranca, String validade, String nomeTitular) {
		this.idPagamento = idPagamento;
		this.valor = valor;
		this.numeroCartao = numeroCartao;
		this.codigoSeguranca = codigoSeguranca;
		this.validade = validade;
		this.nomeTitular = nomeTitular;
	}



	public int getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
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

	@Override
	public Object getChavePrimaria() {
		return getIdPagamento();
	}
	
}
