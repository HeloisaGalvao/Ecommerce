package br.com.loja.modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.loja.interfaces.EntidadeIN;
@Entity
public class Carrinho implements EntidadeIN{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCarrinho;
	private int qtdItens;
	private int qtdProduto;
	private double valorTotal;
	@OneToMany
	private List <Produto> produto;
	@OneToOne
	private Cliente cliente;
	
	
	public Carrinho() {
		
	}
	
	public Carrinho(int idCarrinho, int qtdItens, double valorTotal, int qtdProduto) {
		this.idCarrinho = idCarrinho;
		this.qtdItens = qtdItens;
		this.valorTotal = valorTotal;
		this.qtdProduto = qtdProduto;
	}

	public int getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(int qtdProduto) {
		this.qtdProduto = qtdProduto;
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

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public Object getChavePrimaria() {
		return getIdCarrinho();
	}
	
}
