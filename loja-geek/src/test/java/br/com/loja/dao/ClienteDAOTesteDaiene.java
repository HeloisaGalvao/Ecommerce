package br.com.loja.dao;

import org.junit.Test;

import br.com.loja.modelos.Categoria;
import br.com.loja.modelos.Modelo;
import br.com.loja.modelos.Produto;
import br.com.loja.modelos.TipoTamanho;
import jdk.nashorn.internal.ir.annotations.Ignore;

public class ClienteDAOTesteDaiene {


	@Test
	public void inserirProduto() {
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(1);
		Produto p = new Produto();
		p.setDescricao("Camisa Homem Aranha");
		p.setModelo(Modelo.FEMININO);
		p.setPreco(29.99);
		p.setTamanho(TipoTamanho.P);		
		p.setCategoria(categoria);
		
		ProdutoDAO pd = new ProdutoDAO();
		pd.inserir(p);

	}
	@Test
	@Ignore
	public void inserirCategoria() {
		Categoria categoria1 = new Categoria();
		categoria1.setNomeCategoria("Desenhos");
		
		CategoriaDAO categoriaDAO1 = new CategoriaDAO();
		categoriaDAO1.inserir(categoria1);
	}


}
