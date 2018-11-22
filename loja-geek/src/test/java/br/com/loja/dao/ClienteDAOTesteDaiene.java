package br.com.loja.dao;

import org.junit.Test;

import br.com.loja.modelos.Categoria;
import br.com.loja.modelos.Modelo;
import br.com.loja.modelos.Produto;
import br.com.loja.modelos.TipoTamanho;

public class ClienteDAOTesteDaiene {


	@Test
	public void inserirProduto() {
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(2);
		Produto p = new Produto();
		p.setDescricao("Homem de ferro");
		p.setModelo(Modelo.FEMININO);
		p.setPreco(29.99);
		p.setTamanho(TipoTamanho.P);		
		p.setCategoria(categoria);
		
		ProdutoDAO pd = new ProdutoDAO();
		pd.inserir(p);

	}
	@Test
	public void inserirCategoria() {
		Categoria categoria1 = new Categoria();
		categoria1.setNomeCategoria("Desenho");
		
		CategoriaDAO categoriaDAO1 = new CategoriaDAO();
		categoriaDAO1.inserir(categoria1);
	}


}
