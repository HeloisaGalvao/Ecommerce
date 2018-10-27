package br.com.loja.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.loja.interfaces.EntidadeIN;

@Entity
public class Estoque implements EntidadeIN{

	private int quantidade;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEstoque;
	@ManyToOne
	private Produto produto;
	
	public Estoque() {
		
	}
	
	public Estoque(int quantidade, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(int idEstoque) {
		this.idEstoque = idEstoque;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public Object getChavePrimaria() {
		return getIdEstoque();
	}
	
}
