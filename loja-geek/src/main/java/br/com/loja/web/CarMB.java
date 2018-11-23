package br.com.loja.web;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.loja.dao.CarrinhoDAO;
import br.com.loja.modelos.Carrinho;
import br.com.loja.modelos.Produto;

@ManagedBean
@SessionScoped
public class CarMB implements Serializable {

	private static final long serialVersionUID = 1L;
	Carrinho carrinho = new Carrinho();
	CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
	private List<Produto> lista = new ArrayList<Produto>();
	private double total;
	private int quantidade = 1;
	
	public CarMB() {
		carrinho = carrinhoDAO.consultarCarrinho(LoginMB.getClienteLogado());
		this.lista = carrinho.getProduto();
		this.total = carrinho.getValorTotal();
	}
	
	public Carrinho getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}

	public List<Produto> getLista() {
		return lista;

	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}
	
	public double getTotal() {
		return total;
	}

	public void removerItem(Produto produto) throws IOException {
		Carrinho carrinhoRemover = new Carrinho();
		carrinhoRemover = carrinho;
		
		carrinho.getProduto().remove(produto);
		
		double valorTotal = carrinho.getValorTotal() - produto.getPreco();
		carrinho.setValorTotal(valorTotal);
		
		carrinhoDAO.alterar(carrinhoRemover);
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("car.xhtml");
		
	}
	
	public void finalizar() throws IOException {
		 FacesContext.getCurrentInstance().getExternalContext().redirect("pedido.xhtml");
	}
}
