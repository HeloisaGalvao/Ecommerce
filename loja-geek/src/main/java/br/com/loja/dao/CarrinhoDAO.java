package br.com.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.loja.modelos.Carrinho;

public class CarrinhoDAO extends AbstractDAO{

	private EntityManager em = UtilJPA.getEntityManager();
	
	public Carrinho consultarCarrinho(String cpf) {
        String QUERY = "Select c From Carrinho c where cliente_CpfCliente = ?1";		
		
		TypedQuery <Carrinho> consultarCarrinho = em.createQuery(QUERY, Carrinho.class);
		consultarCarrinho.setParameter(1, cpf);
		
		return consultarCarrinho.getSingleResult();
	}
	
	public void excluirCarrinho(String cpf) {
		Carrinho carrinho = new Carrinho();
		carrinho = consultarCarrinho(cpf);
		excluirPorChavePrimaria(Carrinho.class, carrinho.getChavePrimaria());
		
	}
	
	/*public List<Produto> listarProdutosCarrinho(String cpf){
		String QUERY = "Select c From Carrinho c where cliente_CpfCliente = ?1";		
		
		TypedQuery <Carrinho> consultarCarrinho = em.createQuery(QUERY, Carrinho.class);
		consultarCarrinho.setParameter(1, cpf);
		
		return consultarCarrinho.getSingleResult();
		
	}*/
}

