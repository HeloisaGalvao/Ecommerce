package br.com.loja.web;


import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.loja.dao.CarrinhoDAO;
import br.com.loja.dao.FormaDePagamentoDAO;
import br.com.loja.dao.ItensDoPedidoDAO;
import br.com.loja.dao.PedidoDAO;
import br.com.loja.modelos.Carrinho;
import br.com.loja.modelos.Estado;
import br.com.loja.modelos.FormaDePagamento;
import br.com.loja.modelos.ItensDoPedido;
import br.com.loja.modelos.Pedido;
import br.com.loja.modelos.Produto;

@ManagedBean
@ViewScoped
public class PedidoMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Calendar data;
	private String logradouro, numero, complemento, CEP, bairro, cidade, numeroCartao, codigoSeguranca, validade, nomeTitular;
	private Estado estado;
	
	FormaDePagamento formaDePagamento = new FormaDePagamento();

	private Pedido pedido;
	
	public PedidoMB() {
		if (this.pedido == null) {
			this.pedido = new Pedido();	
		}
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}
	
	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	
	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void save() throws IOException {
		Carrinho carrinho = new Carrinho();
		CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
		List<Produto> lista = new ArrayList<Produto>();
		FormaDePagamento formaDePagamento = new FormaDePagamento();
		FormaDePagamentoDAO formaDePagamentoDAO = new FormaDePagamentoDAO();
		Pedido pedido = new Pedido();
		PedidoDAO pedidoDAO = new PedidoDAO();
		ItensDoPedido itens = new ItensDoPedido();
	
		carrinho = carrinhoDAO.consultarCarrinho(LoginMB.getClienteLogado());

		formaDePagamento.setNumeroCartao(getNumeroCartao());
		formaDePagamento.setNomeTitular(getNomeTitular());
		formaDePagamento.setValidade(getValidade());
		formaDePagamento.setCodigoSeguranca(getCodigoSeguranca());
		formaDePagamento.setValor(BigDecimal.valueOf(carrinho.getValorTotal()));
		formaDePagamentoDAO.inserir(formaDePagamento);
		
		pedido.setLogradouro(getLogradouro());
		pedido.setNumero(getNumero());
		pedido.setBairro(getBairro());
		pedido.setCidade(getCidade());
		pedido.setEstado(getEstado());
		pedido.setComplemento(getComplemento());
		pedido.setCEP(getCEP());
		data = Calendar.getInstance();
		pedido.setData(data);
		pedido.setCliente(carrinho.getCliente());
		
		lista = carrinho.getProduto();
		Produto produto = lista.get(0);
		
		itens.setIdPedido(pedido);
		itens.setIdProduto(produto);
		itens.setQuantidade(1);
		ItensDoPedidoDAO ipd = new ItensDoPedidoDAO();
		ipd.inserir(itens);
		
		if (lista.size()>1) {
			pedido = pedidoDAO.consultarPedido(pedido.getCliente().getCpf(), pedido.getData());
			
			for (int i = 1; i <= lista.size(); i++) {
				itens.setIdPedido(pedido);
				itens.setIdProduto(lista.get(i));
				itens.setQuantidade(1);
				ipd.alterar(itens);
			}
		}
		carrinhoDAO.excluirCarrinho(LoginMB.getClienteLogado());
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
	}	
} 