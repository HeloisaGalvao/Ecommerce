package br.com.loja.modelos;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.loja.interfaces.EntidadeIN;

@Entity
public class Produto implements EntidadeIN {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduto;
	private double preco;
	private String descricao;
	@Enumerated(EnumType.STRING)	
	private TipoTamanho tamanho;
	@Enumerated(EnumType.STRING)
	private Modelo modelo;
	@ManyToOne
	private Categoria categoria;


	public Produto(int idProduto, double preco, String descricao, TipoTamanho tamanho, Modelo modelo){
		this.idProduto = idProduto;
		this.descricao = descricao;
		this.preco = preco;
		this.tamanho = tamanho;
		this.modelo= modelo;
	}
	
	public Produto() {
		
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
	
	@Override
	public Object getChavePrimaria() {
		return getIdProduto();
	}

}
