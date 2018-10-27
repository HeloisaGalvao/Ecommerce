package br.com.loja.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.loja.interfaces.EntidadeIN;

@Entity
public class Categoria implements EntidadeIN {
	
	private String nomeCategoria;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategoria;
	
	
	public Categoria() {
		
	}
	
	public Categoria(int idCategoria,String nomeCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.nomeCategoria = nomeCategoria;

	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Override
	public Object getChavePrimaria() {
		return getIdCategoria();
	}
		
}
