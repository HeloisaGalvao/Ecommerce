package br.com.loja.dao;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.loja.modelos.Pedido;

public class PedidoDAO extends AbstractDAO {
	
private EntityManager em = UtilJPA.getEntityManager();
	
	public Pedido consultarPedido(String cpf, Calendar data) {
        String QUERY = "Select p From Pedido p where cliente_CpfCliente = ?1 and data = ?2";		
		
		TypedQuery <Pedido> consultarPedido = em.createQuery(QUERY, Pedido.class);
		consultarPedido.setParameter(1, cpf);
		consultarPedido.setParameter(2, data);
		
		return consultarPedido.getSingleResult();
	}
	
		
		
}

