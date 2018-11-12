package br.com.loja.dao;

import br.com.loja.modelos.Cliente;

public class ClienteDAOTesteDaiene {

	
	public void testarT() {
		ClienteDAO dao = new ClienteDAO();
		Cliente c = new Cliente();
		c.setLogin("HeloisaGalvao");
		c.setSenha("1234");
		c = dao.getLoginSenha(c.getLogin(), c.getSenha());

		
		System.out.println("Login " + c.getLogin());
		System.out.println("senha " + c.getSenha());
	}

}
