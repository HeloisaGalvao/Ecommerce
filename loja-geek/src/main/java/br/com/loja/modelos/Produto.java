package br.com.loja.modelos;

import java.math.BigDecimal;

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
	private BigDecimal preco;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private TipoTamanho tamanho;	
	private String tipoPorduto;
	
	@ManyToOne
	private Categoria categoria;
	
	public Produto(int idProduto, BigDecimal preco, String descricao, TipoTamanho tamanho, String tipoProduto){
		this.idProduto = idProduto;
		this.descricao = descricao;
		this.preco = preco;
		this.tamanho = tamanho;
		this.tipoPorduto= tipoProduto;
	}
	
	public Produto() {
		
	}

	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public TipoTamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(TipoTamanho tamanho) {
		this.tamanho = tamanho;
	}

	public String getTipoPorduto() {
		return tipoPorduto;
	}

	public void setTipoPorduto(String tipoPorduto) {
		this.tipoPorduto = tipoPorduto;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public Object getChavePrimaria() {
		return getIdProduto();
	}

}
