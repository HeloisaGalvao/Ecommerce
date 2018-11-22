package br.com.loja.web;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.loja.dao.CarrinhoDAO;
import br.com.loja.modelos.Carrinho;
import br.com.loja.modelos.Produto;

@ManagedBean
@SessionScoped
public class CarMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Carrinho carrinho = new Carrinho();
	CarrinhoDAO cd = new CarrinhoDAO();
	Produto produto = new Produto();
	private List<Produto> lista = new ArrayList<Produto>();
	private double total;
	private int quantidade = 1;
	
	public CarMB() {
		//ProdutoDAO pd = new ProdutoDAO();
		//this.lista = pd.listarProdutos();
		carrinho = cd.consultarCarrinho(LoginMB.getClienteLogado());
		this.lista = carrinho.getProduto();
		System.out.println("listou");
	}
	@PostConstruct
	public void init() {
		for (Produto produto : lista) {
			this.total += (produto.getPreco() * produto.getQuantidade());
		}
	}
	
	public Carrinho getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getLista() {
		return lista;

	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}
	
	public double getTotal() {
		return total;
	}

	public void removerItem(Produto produto) throws IOException {
		System.out.println("entrou Remover");
		List<Produto> listaAux = new ArrayList<Produto>();
		Carrinho carrinhoRemover = new Carrinho();
		listaAux.add(produto);
		System.out.println("add produto");
//		carrinhoRemover.setIdCarrinho(carrinho.getIdCarrinho());
//		System.out.println("set id");
		carrinhoRemover.setProduto(listaAux);
		System.out.println("setlistaAux");
		cd.excluirPorObjeto(carrinhoRemover);
		System.out.println("excluiu");
		FacesContext.getCurrentInstance().getExternalContext().redirect("car.xhtml");
		
	}
	
	public void quantidadeADD() {
		if(quantidade > 0) {
			quantidade = quantidade + 1;
		}
		
		System.out.println("contou" + quantidade);
	}
	
	public void quantidadeREM() {
		if(quantidade > 1) {
			quantidade = quantidade - 1;
		}
		
		System.out.println("contou" + quantidade);
	}
	

	public void totalizar() {
	
		for (Produto produto : lista) {
			total =+ produto.getPreco();
		}
		
		System.out.println("contou");
		System.out.println(this.total);
	}
	
	public void finalizar() throws IOException {
		 FacesContext.getCurrentInstance().getExternalContext().redirect("pedido.xhtml");
	}
}
