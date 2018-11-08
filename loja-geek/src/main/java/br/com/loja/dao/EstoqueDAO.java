package br.com.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.loja.modelos.Estoque;

public class EstoqueDAO extends AbstractDAO{

	public Estoque consultarEstoqueProduto(int produto) {
		EntityManager EM = UtilJPA.getEntityManager();
		Estoque estoque = new Estoque();
		
		String QUERY = "Select e From Estoque e where produto_idProduto = ?1";		
		
		TypedQuery<Estoque> queryConsultaEstoque = EM.createQuery(QUERY, Estoque.class);
		queryConsultaEstoque.setParameter(1, produto);
		
		estoque = queryConsultaEstoque.getSingleResult(); 
		
		return estoque;
	}
}
