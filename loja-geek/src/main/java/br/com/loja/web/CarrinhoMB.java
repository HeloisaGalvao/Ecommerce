package br.com.loja.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.loja.modelos.Modelo;
import br.com.loja.modelos.Produto;
import br.com.loja.modelos.TipoTamanho;

@ManagedBean
public class CarrinhoMB {
	
	//final Double valor = 10.0;
	private Double valor;
	
	public void setValor(Double valor) {
		this.valor = valor;
	}

	private Integer spinner = 1;
	private Double atualValor = 0.0;
	private List<Produto> lista = new ArrayList<Produto>();
	
	public Double getValor() {
		return valor;
	}

	public Integer getSpinner() {
		return spinner;
	}

	public void setSpinner(Integer spinner) {
		this.spinner = spinner;
	}
	
	public Double getAtualValor() {
		setAtualValor(valor * spinner);
		return this.atualValor;
	}
	
	public void setAtualValor(Double atualValor) {
			this.atualValor = atualValor;			
	}
	
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
    	setValor(produto.getPreco());
    	//produto.setSubtotal(29.99);
    	lista.add(produto);
    	
    	p1.setIdProduto(2);
    	p1.setDescricao("CAMISA TESTE2");
    	Modelo m1 = Modelo.FEMININO;
    	p1.setModelo(m1);
    	TipoTamanho pp = TipoTamanho.P;
    	p1.setTamanho(pp);
    	p1.setPreco(49.99);
    	setValor(p1.getPreco());
    	//p1.setSubtotal(calcularSubtotal(p1.getPreco(), p1.getQuantidade()));
    	//p1.setSubtotal(99.98);
    	lista.add(p1);
    	
    	return lista;
    	
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}
	
	public double calcularSubtotal (double preco, int qtde) {
		return (preco * qtde);
	}
	
	public void removerItem (int rowIndex) {
		lista.remove(rowIndex);
	}
}
