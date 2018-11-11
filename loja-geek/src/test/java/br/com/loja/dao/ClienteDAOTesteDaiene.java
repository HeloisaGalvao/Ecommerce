package br.com.loja.dao;

import org.junit.Test;

import br.com.loja.modelos.Cliente;
import jdk.nashorn.internal.ir.annotations.Ignore;

public class ClienteDAOTesteDaiene {
	@Ignore
	@Test
	public void testar() {
		ClienteDAO dao = new ClienteDAO();
		for(Cliente c: dao.getLoginSenha("HeloisaGalvao", "1234")) {
			System.out.println("Login " + c.getLogin());
			System.out.println("senha " + c.getSenha());
		}
		
	}
	
	public void testarT() {
		ClienteDAO dao = new ClienteDAO();
		Cliente c = new Cliente();
		c.setLogin("HeloisaGalvao");
		c.setSenha("1234");
		//c = dao.getLoginSenhaT(c.getLogin(), c.getSenha());
		c = dao.getLoginT(c.getLogin());
		
		System.out.println("Login " + c.getLogin());
		System.out.println("senha " + c.getSenha());
	}

}
