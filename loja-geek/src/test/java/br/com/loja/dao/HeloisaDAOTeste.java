package br.com.loja.dao;

public class HeloisaDAOTeste {

	/*@Ignore
	@Test
	public void inserirItensDoPedido() {
		Cliente c = new Cliente();
		c.setCpf("10808803484");
		c.setNomeCliente("Heloísa Rayanne Barbosa Galvão");
		c.setEmail("heloisa0rayane@gmail.com");
		c.setSenha("123456");
		
		ClienteDAO cd = new ClienteDAO();
	    cd.inserir(c);
//	    }
//	
//	@Test
//	public void inserirCategoria() {
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
		p.setPreco(39.90);
		p.setTamanho(TipoTamanho.P);		
		p.setCategoria(ct);
		
		ProdutoDAO pd = new ProdutoDAO();
		pd.inserir(p);
		
		Estoque e = new Estoque();
		e.setProduto(p);
		e.setQuantidade(3);
		
		EstoqueDAO ed = new EstoqueDAO();
		ed.inserir(e);
//		}
//	
//	@Test
//	public void inserirPedido() {
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
		
		
		
	}*/
	
/*	@Test
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
	}*/
/*
	@Test
	public void inserirProduto() {
		Produto p = new Produto();
		Categoria ct = new Categoria();
		ct.setIdCategoria(1);
		p.setDescricao("Moleton de Star Wars2");
		p.setModelo(Modelo.FEMININO);
		p.setPreco(29.50);
		p.setTamanho(TipoTamanho.M);		
		p.setCategoria(ct);
		
		ProdutoDAO pd = new ProdutoDAO();
		pd.inserir(p);
		
		}*/
	/*
	@Test
	public void listarProdutos() {
		ProdutoDAO pd = new ProdutoDAO();
		List<Produto> lista = new ArrayList<Produto>();
		lista = pd.listarProdutos();
		
		for (Produto produto : lista) {
			System.out.println(produto.getIdProduto());
			System.out.println(produto.getDescricao());
			System.out.println(produto.getPreco());
			System.out.println(produto.getCategoria());
			System.out.println(produto.getModelo());
			System.out.println(produto.getTamanho());
			
			
		}
	}*/
	
	/*@Test
	public void inserirCarrinho() {
		Carrinho cart = new Carrinho();
		CarrinhoDAO cd = new CarrinhoDAO();
		ProdutoDAO pd = new ProdutoDAO();
		
		Cliente cli = new Cliente();
		cli.setCpf("10808803484");
		
		List <Produto> prd = new ArrayList<Produto>();
		prd = pd.listarProdutos();
		
		cart.setCliente(cli);
		cart.setValorTotal(3);
		cart.setProduto(prd);
		
		cd.inserir(cart);
		}*/
	/*@Test
	public void inseriritens() {
		Cliente c = new Cliente();
		Produto p = new Produto();
		p.setIdProduto(2);
		
		c.setCpf("10808803484");
		Pedido pedido  = new Pedido();
		//buscar idvenda
		pedido.setCEP("5234-423");
		pedido.setBairro("Beberibe");
		pedido.setCidade("Recife");
		pedido.setComplemento("Próximo ao posto de saúde");
		pedido.setEstado(Estado.PE);
		pedido.setLogradouro("Beco da vitória");
		pedido.setNumero("377");
		pedido.setCliente(c);
		ItensDoPedido itens = new ItensDoPedido();
		itens.setIdPedido(pedido);
		itens.setIdProduto(p);
		itens.setQuantidade(2);
		ItensDoPedidoDAO ipd = new ItensDoPedidoDAO();
		ipd.alterar(itens);
	}*/
}