package br.com.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.loja.modelos.Produto;

public class ProdutoDAO extends AbstractDAO {
	
	public List<Produto> listarProdutos() {
		EntityManager EM = UtilJPA.getEntityManager();
		int ZERO = 0;
		int NOVE = 99;
		
		//Listar todos os produtos
		String QUERY = "Select p From Produto p where idProduto between ?1 and ?2";		
		
		TypedQuery<Produto> queryListarProdutos = EM.createQuery(QUERY, Produto.class);
		queryListarProdutos.setParameter(1, ZERO);
		queryListarProdutos.setParameter(2, NOVE);
		return queryListarProdutos.getResultList();
	}
		
}

