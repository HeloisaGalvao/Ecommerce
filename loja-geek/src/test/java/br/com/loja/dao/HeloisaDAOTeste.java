package br.com.loja.dao;


import org.junit.Test;

import br.com.loja.modelos.Categoria;
import br.com.loja.modelos.Cliente;
import br.com.loja.modelos.Estado;
import br.com.loja.modelos.Estoque;
import br.com.loja.modelos.FormaDePagamento;
import br.com.loja.modelos.ItensDoPedido;
import br.com.loja.modelos.Modelo;
import br.com.loja.modelos.Pedido;
import br.com.loja.modelos.Produto;
import br.com.loja.modelos.TipoDePagamento;
import br.com.loja.modelos.TipoTamanho;

public class HeloisaDAOTeste {

	@Test
	public void inserirItensDoPedido() {
		Cliente c = new Cliente();
		c.setCpf("108.088.034-84");
		c.setNomeCliente("Heloísa Rayanne Barbosa Galvão");
		c.setEmail("heloisa0rayane@gmail.com");
		/*c.setLogin("HeloisaGalvao");*/
		c.setSenha("1234");
		
		ClienteDAO cd = new ClienteDAO();
	    cd.inserir(c);

	/*}
	
	@Test
	public void inserirCategoria() {*/
		Categoria ct = new Categoria();
		ct.setNomeCategoria("Moleton");
		
		CategoriaDAO ctd = new CategoriaDAO();
		ctd.inserir(ct);
	//}
	
	//@Test
	//public void inserirProduto() {
		Produto p = new Produto();
		p.setDescricao("Moleton de Star Wars");
		p.setModelo(Modelo.FEMININO);
	
		p.setTamanho(TipoTamanho.P);		
		p.setCategoria(ct);
		
		ProdutoDAO pd = new ProdutoDAO();
		pd.inserir(p);
		
		Estoque e = new Estoque();
		e.setProduto(p);
		e.setQuantidade(3);
		
		EstoqueDAO ed = new EstoqueDAO();
		ed.inserir(e);
		/*}
	
	@Test
	public void inserirPedido() {*/
		Pedido pedido  = new Pedido();
		pedido.setCEP("5234-423");
		pedido.setBairro("Beberibe");
		pedido.setCidade("Recife");
		pedido.setComplemento("Próximo ao posto de saúde");
		pedido.setEstado(Estado.PE);
		pedido.setLogradouro("Beco da vitória");
		pedido.setNumero("377");
		pedido.setCliente(c);
		
		FormaDePagamento fdp = new FormaDePagamento();
		fdp.setTipoDePagamento(TipoDePagamento.BOLETO);
		
		FormaDePagamentoDAO fdpd = new FormaDePagamentoDAO();
		fdpd.inserir(fdp);
		
		pedido.setFormaDePagamento(fdp);
		
		//PedidoDAO ped = new PedidoDAO();		
		//ped.inserir(pedido);
		
		ItensDoPedido itens = new ItensDoPedido();
		itens.setIdPedido(pedido);
		itens.setIdProduto(p);
		itens.setQuantidade(1);
		ItensDoPedidoDAO ipd = new ItensDoPedidoDAO();
		ipd.inserir(itens);
		
		
		
	}
	
	@Test
	public void atualizarEstoque() {
		//-- parâmetros considerados --
		Produto p = new Produto();
		p.setIdProduto(1);
		
		ItensDoPedido itens = new ItensDoPedido();
		itens.setQuantidade(1);
		//--
		
		EstoqueDAO ed = new EstoqueDAO();
	
		Estoque estoque = new Estoque();
		
		estoque = ed.consultarEstoqueProduto(p.getIdProduto());
		
		// colocar validação antes de inserir pedido 
		if (estoque.getQuantidade() < 1)
			System.out.println("estoque insuficiente");
		else {
			estoque.setQuantidade(estoque.getQuantidade() - itens.getQuantidade());

			ed.alterar(estoque);
		}
	}

}
