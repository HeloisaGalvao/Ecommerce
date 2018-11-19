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
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.modelos.Carrinho;
import br.com.loja.modelos.Produto;

@ManagedBean
@SessionScoped
public class CarrinhoFinalMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Carrinho carrinho = new Carrinho();
	Produto produto = new Produto();
	private List<Produto> lista = new ArrayList<Produto>();
	private double total;
	private int quantidade = 1;
	
	public CarrinhoFinalMB() {
		CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
		carrinho = carrinhoDAO.consultarCarrinho(LoginMB.getClienteLogado());
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
		System.out.println("removeu");
		ProdutoDAO pd = new ProdutoDAO();
		pd.excluirPorObjeto(produto);
		FacesContext.getCurrentInstance().getExternalContext().redirect("produto.xhtml");
		
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
