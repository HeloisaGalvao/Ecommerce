package br.com.loja.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.loja.modelos.Cliente;

public class ClienteDAO extends AbstractDAO{
	private EntityManager em = UtilJPA.getEntityManager();
	
	public List<Cliente> getEmailVerifica(String email){

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> query = criteriaBuilder.createQuery(Cliente.class);
		Root<Cliente> root = query.from(Cliente.class);
		Path<String> emailPath = root.<String> get("email");
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (!email.isEmpty()) {
			Predicate emailIgual = criteriaBuilder.equal(emailPath, email);
			predicates.add(emailIgual);
		}
		query.where((Predicate[]) predicates.toArray(new Predicate[0]));
		TypedQuery<Cliente> typedQuery = em.createQuery(query);
		return  typedQuery.getResultList();
	}
	
	
	public Cliente getEntrar(String email, String senha) {
		Cliente cliente = new Cliente();
        String QUERY = "Select c From Cliente c where email = ?1 and senha = ?2";		
		
		TypedQuery<Cliente> queryConsultaLogin = em.createQuery(QUERY, Cliente.class);
		queryConsultaLogin.setParameter(1, email);
		queryConsultaLogin.setParameter(2, senha);
		
		cliente = queryConsultaLogin.getSingleResult(); 
		
		return cliente;
	}
	
	
}
