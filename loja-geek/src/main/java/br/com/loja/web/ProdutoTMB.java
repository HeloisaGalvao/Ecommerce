package br.com.loja.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.loja.modelos.Categoria;
import br.com.loja.modelos.Modelo;
import br.com.loja.modelos.Produto;
import br.com.loja.modelos.TipoTamanho;

@ManagedBean
public class ProdutoTMB {
	private int idProduto;
	private double preco;
	private String descricao;
	private TipoTamanho tamanho;
	private Modelo modelo;
	private Categoria categoria;

	private List<Produto> lista = new ArrayList<Produto>();
	Produto produto ;   
	
	public ProdutoTMB() {
		if (this.produto == null) {
			this.produto = new Produto();	
		}
	}
	
	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoTamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(TipoTamanho tamanho) {
		this.tamanho = tamanho;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Produto> getLista() {
/*		Produto produto = new Produto();
		Produto p1 = new Produto();
    	produto.setIdProduto(1);
    	produto.setDescricao("CAMISA TESTE1");
    	Modelo m = Modelo.MASCULINO;
    	produto.setModelo(m);
    	TipoTamanho p = TipoTamanho.P;
    	produto.setTamanho(p);
    	produto.setPreco(29.99);
    	lista.add(produto);
    	
    	p1.setIdProduto(2);
    	p1.setDescricao("CAMISA TESTE2");
    	Modelo m1 = Modelo.FEMININO;
    	p1.setModelo(m1);
    	TipoTamanho pp = TipoTamanho.P;
    	p1.setTamanho(pp);
    	p1.setPreco(49.99);
    	lista.add(p1);*/
    	return lista;
    	
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}
	
	public void removerItemT (int id) {
		System.out.println(id);
		lista.remove(id);
	}
	
	public void inserir() {
		System.err.println("B");
		if ( this.produto != null ) { 
			System.err.println("A");
			lista.add(produto);
		}
	}
	
}