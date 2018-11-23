package br.com.loja.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.loja.dao.CarrinhoDAO;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.modelos.Carrinho;
import br.com.loja.modelos.Cliente;
import br.com.loja.modelos.Produto;

@ManagedBean
@SessionScoped
public class HomeMB {
	
	Carrinho carrinho = new Carrinho();
	CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
	ProdutoDAO produtoDAO = new ProdutoDAO();
	private List<Produto> lista = new ArrayList<Produto>();
	private static List<Produto> listaProdutosCart = new ArrayList<Produto>();
	private static double valorTotal;
	private static int quantidade = 0;
	private String logado;

	public HomeMB(){
		if (this.lista.isEmpty())
			this.lista = produtoDAO.listarProdutos();
	}
	
	@PostConstruct
	public void init() {
		this.logado = LoginMB.getNomeClienteLogado();
		if(logado == null) {
			logado = "Não Registrado";
		}
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	
	public String getLogado() {
		return logado;
	}

	public void setLogado(String logado) {
		this.logado = logado;
	}

	public List<Produto> getLista() {
		return lista;
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		HomeMB.valorTotal = valorTotal;
	}

	public List<Produto> getListaProdutosCart() {
		return listaProdutosCart;
	}

	public void setListaProdutosCart(List<Produto> listaProdutosCart) {
		HomeMB.listaProdutosCart = listaProdutosCart;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		HomeMB.quantidade = quantidade;
	}

	public void add(Produto produto) {
		HomeMB.valorTotal += produto.getPreco();
		increment();
		listaProdutosCart.add(produto);
	}
	
	public void carrinho() throws IOException {

		if (listaProdutosCart.isEmpty()) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("produto.xhtml");
		}else {
			String cpf = LoginMB.getClienteLogado();
			Cliente cli = new Cliente();
			cli.setCpf(cpf);

			carrinho.setCliente(cli);
			carrinho.setValorTotal(HomeMB.valorTotal);
			carrinho.setProduto(listaProdutosCart);

			carrinhoDAO.inserir(carrinho);
			FacesContext.getCurrentInstance().getExternalContext().redirect("carrinho.xhtml");
		}

	}
	
	public void increment() {
		quantidade++;
	}
}
