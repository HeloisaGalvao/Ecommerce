package br.com.loja.dao;

import org.junit.Test;

import br.com.loja.modelos.Cliente;

public class ClienteDAOTesteDaiene {
	@Test
	public void testar() {
		ClienteDAO dao = new ClienteDAO();
		for(Cliente c: dao.getLoginSenha("daien", "daiene")) {
			System.out.println("Login " + c.getLogin());
			System.out.println("senha " + c.getSenha());
		}
		
	}

}
