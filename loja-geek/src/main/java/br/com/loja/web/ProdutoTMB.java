package br.com.loja.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.loja.modelos.Modelo;
import br.com.loja.modelos.Produto;
import br.com.loja.modelos.TipoTamanho;

@ManagedBean
public class ProdutoTMB {
	
	private List<Produto> lista = new ArrayList<Produto>();
	

	public List<Produto> getLista() {
		Produto produto = new Produto();
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
    	lista.add(p1);
    	return lista;
    	
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}
    
}
