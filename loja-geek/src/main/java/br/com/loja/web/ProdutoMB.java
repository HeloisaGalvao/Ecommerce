package br.com.loja.web;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import br.com.loja.dao.ProdutoDAO;
import br.com.loja.modelos.Produto;

@ManagedBean
@SessionScoped
public class ProdutoMB {
//    daiene
	public ProdutoMB() {
		ProdutoDAO pd = new ProdutoDAO();
		this.lista = pd.listarProdutos();
		System.out.println("listou");
		/*
		for (Produto produto : lista) {
			System.out.println(produto.getIdProduto());
			System.out.println(produto.getDescricao());
			System.out.println(produto.getPreco());
			System.out.println(produto.getModelo());
			System.out.println(produto.getTamanho());
		}*/
	}
	Produto produto = new Produto();
	private List<Produto> lista = new ArrayList<Produto>();

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getLista() {
		return lista;

	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}
	
	public void removerItem(Produto produto) {
	/*	System.out.println("achou");
		lista.remove(id);
		System.out.println("removeu");*/
		ProdutoDAO pd = new ProdutoDAO();
		pd.excluirPorObjeto(produto);
		this.refresh();
		
	}

	public void refresh() {
		System.out.println("refresh");
		// teste para atualizar página (NÃO FUNCIONOU)
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	}
}
