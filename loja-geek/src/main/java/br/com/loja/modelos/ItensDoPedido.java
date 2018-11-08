package br.com.loja.modelos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.loja.interfaces.EntidadeIN;

@Entity
public class ItensDoPedido implements EntidadeIN {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idItensDoPedido;
	@ManyToOne(cascade=CascadeType.ALL)
	private Pedido idPedido;
	@ManyToOne(cascade=CascadeType.ALL)
	private Produto idProduto;
	private int quantidade;
	
	public ItensDoPedido() {
		
	}
	
	public ItensDoPedido(int idItensDoPedido, Pedido idPedido, Produto idProduto, int quantidade) {
		this.idItensDoPedido = idItensDoPedido;
		this.idPedido = idPedido;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}
	
	public int getIdItensDoPedido() {
		return idItensDoPedido;
	}
	public void setIdItensDoPedido(int idItensDoPedido) {
		this.idItensDoPedido = idItensDoPedido;
	}
	public Pedido getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Pedido idPedido) {
		this.idPedido = idPedido;
	}
	public Produto getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Produto idProduto) {
		this.idProduto = idProduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public Object getChavePrimaria() {
		return getIdItensDoPedido();
	}
}
