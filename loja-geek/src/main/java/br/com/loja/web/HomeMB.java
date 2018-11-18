package br.com.loja.web;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import br.com.loja.dao.CarrinhoDAO;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.modelos.Carrinho;
import br.com.loja.modelos.Produto;

@ManagedBean
@SessionScoped
public class HomeMB {
	
	Carrinho carrinho = new Carrinho();
	Produto produto = new Produto();
	private List<Produto> lista = new ArrayList<Produto>();
	private double valorTotal;
	private int id;
	
	public HomeMB(){
		ProdutoDAO pd = new ProdutoDAO();
		this.lista = pd.listarProdutos();
	}
	
	public void add(Produto produto) {
		lista.add(produto);
		CarrinhoDAO dao = new CarrinhoDAO();
		dao.inserir(produto);
		
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
		System.out.println("b");
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getLista() {
		return lista;
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
