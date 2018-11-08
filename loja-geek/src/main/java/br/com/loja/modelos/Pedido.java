package br.com.loja.modelos;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.loja.interfaces.EntidadeIN;
@Entity
public class Pedido implements EntidadeIN {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVenda;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	private String logradouro;
	private String numero;
	private String complemento;
	private String CEP;
	private String bairro;
	private String cidade;
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	@OneToOne
	private FormaDePagamento formaDePagamento;
	@OneToMany(mappedBy="idPedido", cascade=CascadeType.ALL)
	private List <ItensDoPedido> itensDoPedido;
	@OneToOne
	private Cliente cliente;
	
	public Pedido() {
		
	}
	
	public Pedido(int idVenda, Calendar data, String logradouro, String numero, String complemento, String cEP,
			String bairro, String cidade, Estado estado) {
		this.idVenda = idVenda;
		this.data = data;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		CEP = cEP;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
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
	
	public int getIdVenda() {
		return idVenda;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	
	public List<ItensDoPedido> getItensDoPedido() {
		return itensDoPedido;
	}

	public void setItensDoPedido(List<ItensDoPedido> itensDoPedido) {
		this.itensDoPedido = itensDoPedido;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public Object getChavePrimaria() {
		return getIdVenda();
	}

}
