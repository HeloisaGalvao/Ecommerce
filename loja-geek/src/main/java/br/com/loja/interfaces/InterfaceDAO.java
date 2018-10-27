package br.com.loja.interfaces;



public interface InterfaceDAO {
	public void inserir(EntidadeIN pEntidade);
	//public void alterar(EntidadeIN pEntidade);
	public void excluirPorChavePrimaria(@SuppressWarnings("rawtypes") Class pClasse, Object pPrimaryKey);
	public void excluirPorObjeto(EntidadeIN pEntidade);
	public EntidadeIN consultarPorChavePrimaria(@SuppressWarnings("rawtypes") Class pClasse, Object pPrimaryKey);
	public EntidadeIN consultarPorObjeto(EntidadeIN pEntidade);
}
