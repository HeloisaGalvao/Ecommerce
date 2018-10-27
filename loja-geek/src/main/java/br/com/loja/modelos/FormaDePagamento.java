package br.com.loja.modelos;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FormaDePagamento {
	
	@Id
	private int idPagamento;
	private TipoDePagamento tipoDePagamento;
	private BigDecimal valor;
	private String numeroCartao;
	private String codigoSeguranca;
	private String validade;
	private String nomeTitular;
	
	public FormaDePagamento() {
		
	}
	
	public FormaDePagamento(int idPagamento, TipoDePagamento tipoDePagamento, BigDecimal valor, String numeroCartao,
			String codigoSeguranca, String validade, String nomeTitular) {
		super();
		this.idPagamento = idPagamento;
		this.tipoDePagamento = tipoDePagamento;
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
	public TipoDePagamento getTipoDePagamento() {
		return tipoDePagamento;
	}
	public void setTipoDePagamento(TipoDePagamento tipoDePagamento) {
		this.tipoDePagamento = tipoDePagamento;
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
	
}
