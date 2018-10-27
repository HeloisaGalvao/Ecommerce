package br.com.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.loja.interfaces.EntidadeIN;
import br.com.loja.interfaces.InterfaceDAO;

public abstract class AbstractDAO implements InterfaceDAO {
	public void inserir(EntidadeIN pEntidade) {
		inserir(pEntidade, UtilJPA.getEntityManager(), true);
	}
				
	public void inserir(
		EntidadeIN pEntidade, EntityManager pEM, boolean pFecharEM) {
			pEM.getTransaction().begin();
			pEM.persist(pEntidade);
			pEM.getTransaction().commit();
			if ( pFecharEM ) {
			pEM.close();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public EntidadeIN consultarPorChavePrimaria(Class pClasse, Object pPrimaryKey) {
		return consultarPorChavePrimaria(
		pClasse, pPrimaryKey, UtilJPA.getEntityManager(), true);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EntidadeIN consultarPorChavePrimaria(
	Class pClasse, Object pPrimaryKey,
	EntityManager pEntityManager,boolean pFecharEntityManager) {		
		EntidadeIN registro = (EntidadeIN) pEntityManager.find(pClasse, pPrimaryKey);
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
			return registro;
	}
	public EntidadeIN consultarPorObjeto(EntidadeIN pEntidade) {
		return consultarPorObjeto(pEntidade, UtilJPA.getEntityManager(), true);
	}
	public EntidadeIN consultarPorObjeto(EntidadeIN pEntidade,EntityManager pEntityManager,boolean pFecharEntityManager) {
		EntidadeIN registro =(EntidadeIN) pEntityManager.find(pEntidade.getClass(),pEntidade.getChavePrimaria());
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
			return registro;
	}
	@SuppressWarnings("rawtypes")
	public void excluirPorChavePrimaria(Class pClasse, Object pChavePrimaria) {
		excluirPorChavePrimaria(pClasse, pChavePrimaria,UtilJPA.getEntityManager(), true);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void excluirPorChavePrimaria(
			Class pClasse, Object pChavePrimaria,EntityManager pEntityManager,boolean pFecharEntityManager) {
			pEntityManager.getTransaction().begin();
			Object registro = pEntityManager.find(pClasse, pChavePrimaria);
			pEntityManager.remove(registro);
			pEntityManager.getTransaction().commit();
			if ( pFecharEntityManager ) {
				pEntityManager.close();
			}
		}
	public void excluirPorObjeto(EntidadeIN pEntidade) {
		excluirPorObjeto(pEntidade, UtilJPA.getEntityManager(), true);
	}
	
	public void excluirPorObjeto(EntidadeIN pEntidade,EntityManager pEntityManager,boolean pFecharEntityManager) {
		EntityTransaction transacao = pEntityManager.getTransaction();
		transacao.begin();
		Object registro = pEntityManager.find(pEntidade.getClass(),pEntidade.getChavePrimaria());
		pEntityManager.remove(registro);
		transacao.commit();
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
	}
	
}
