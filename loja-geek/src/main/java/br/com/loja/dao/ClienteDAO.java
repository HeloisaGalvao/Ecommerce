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
import br.com.loja.modelos.Estoque;

public class ClienteDAO extends AbstractDAO{
	private EntityManager em = UtilJPA.getEntityManager();
	
	public List<Cliente> getLogin(String login){
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> query = criteriaBuilder.createQuery(Cliente.class);
		Root<Cliente> root = query.from(Cliente.class);
		Path<String> loginPath = root.<String> get("login");
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (!login.isEmpty()) {
			Predicate loginIgual = criteriaBuilder.equal(loginPath, login);
			predicates.add(loginIgual);
		}
		query.where((Predicate[]) predicates.toArray(new Predicate[0]));
		TypedQuery<Cliente> typedQuery = em.createQuery(query);
		return typedQuery.getResultList();
	}
	
	public List<Cliente> getLoginSenha(String login, String senha){
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> query = criteriaBuilder.createQuery(Cliente.class);
		Root<Cliente> root = query.from(Cliente.class);
		Path<String> loginPath = root.<String> get("login");
		Path<String> senhaPath = root.<String> get("senha");
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (!login.isEmpty()) {
			Predicate loginIgual = criteriaBuilder.equal(loginPath, login);
			predicates.add(loginIgual);
		}
		if (!senha.isEmpty()) {
			Predicate senhaIgual = criteriaBuilder.equal(senhaPath, senha);
			predicates.add(senhaIgual);
		}
		query.where((Predicate[]) predicates.toArray(new Predicate[0]));
		TypedQuery<Cliente> typedQuery = em.createQuery(query);
		return typedQuery.getResultList();
	}
	
	public Cliente getLoginSenhaT(String login, String senha) {
		Cliente cliente = new Cliente();
        String QUERY = "Select c From Cliente c where login = ?1 and senha = ?2";		
		
		TypedQuery<Cliente> queryConsultaLogin = em.createQuery(QUERY, Cliente.class);
		queryConsultaLogin.setParameter(1, login);
		queryConsultaLogin.setParameter(2, senha);
		
		cliente = queryConsultaLogin.getSingleResult(); 
		
		return cliente;
	}
	
	public Cliente getLoginT(String login) {
		Cliente cliente = new Cliente();
		String QUERY = "Select c From Cliente c where login = ?1";		
		
		TypedQuery<Cliente> queryConsultaLogin = em.createQuery(QUERY, Cliente.class);
		queryConsultaLogin.setParameter(1, login);
		
		cliente = queryConsultaLogin.getSingleResult(); 
		
		return cliente;
	}
	
}
