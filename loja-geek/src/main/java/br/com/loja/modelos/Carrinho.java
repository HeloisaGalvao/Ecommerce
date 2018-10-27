package br.com.loja.modelos;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Carrinho {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCarrinho;
	private int qtdItens;
	private BigDecimal valorTotal;
	private Produto produto;
	private Cliente cliente;
	
	public Carrinho() {
		
	}
	
	public Carrinho(int idCarrinho, int qtdItens, BigDecimal valorTotal, Produto produto, Cliente cliente) {
		this.idCarrinho = idCarrinho;
		this.qtdItens = qtdItens;
		this.valorTotal = valorTotal;
		this.produto = produto;
		this.cliente = cliente;
	}


	public int getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(int idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	public int getQtdItens() {
		return qtdItens;
	}

	public void setQtdItens(int qtdItens) {
		this.qtdItens = qtdItens;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
