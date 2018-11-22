package br.com.loja.web;

import java.io.IOException;
import java.io.Serializable;
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
public class ProdutoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Produto produto = new Produto();
	private List<Produto> lista = new ArrayList<Produto>();
	private double total;
	private int quantidade = 1;
	
	public ProdutoMB() {
		ProdutoDAO pd = new ProdutoDAO();
		this.lista = pd.listarProdutos();
	}
	
	@PostConstruct
	public void init() {
		for (Produto produto : lista) {
			this.total += produto.getPreco();
		}
	}
	
	public void setTotal(double total) {
		this.total = total;
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
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}
	
	public double getTotal() {
		return total;
	}

	public void removerItem(Produto produto) throws IOException {
		ProdutoDAO pd = new ProdutoDAO();
		pd.excluirPorObjeto(produto);
		FacesContext.getCurrentInstance().getExternalContext().redirect("produto.xhtml");
		
	}
	
	public void finalizar() throws IOException {
		 FacesContext.getCurrentInstance().getExternalContext().redirect("pedido.xhtml");
	}
}
