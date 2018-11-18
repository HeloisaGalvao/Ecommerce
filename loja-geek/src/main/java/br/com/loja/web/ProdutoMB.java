package br.com.loja.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.loja.dao.ProdutoDAO;
import br.com.loja.modelos.Produto;

@ManagedBean
@SessionScoped
public class ProdutoMB {

	Produto produto = new Produto();
	private List<Produto> lista = new ArrayList<Produto>();
	private double total;
	public ProdutoMB() {
		ProdutoDAO pd = new ProdutoDAO();
		this.lista = pd.listarProdutos();
		System.out.println("listou");
		/*
		for (Produto produto : lista) {
			System.out.println(produto.getIdProduto());
			System.out.println(produto.getDescricao());
			System.out.println(produto.getPreco());
			System.out.println(produto.getModelo());
			System.out.println(produto.getTamanho());
		}*/
	}
	@PostConstruct
	public void init() {
		for (Produto produto : lista) {
			this.total += (produto.getPreco() * produto.getQuantidade());
		}
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
	
	public double getTotal() {
		return total;
	}

	public void removerItem(Produto produto) throws IOException {
		System.out.println("removeu");
		ProdutoDAO pd = new ProdutoDAO();
		pd.excluirPorObjeto(produto);
		FacesContext.getCurrentInstance().getExternalContext().redirect("produto.xhtml");
		
	}

	public void totalizar() {
		for (Produto produto : lista) {
			this.total += produto.getPreco() * produto.getQuantidade();
		}
		System.out.println("contou");
		System.out.println(this.total);
	}
}
