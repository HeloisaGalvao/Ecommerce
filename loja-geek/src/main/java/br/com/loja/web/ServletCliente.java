package br.com.loja.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.loja.dao.ClienteDAO;
import br.com.loja.interfaces.EntidadeIN;
import br.com.loja.modelos.Cliente;
import br.com.loja.regras.ValidarCPF;

@WebServlet("/novoCadastro")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String CADASTRO = "/jsp/formCadastro.jsp";
	private static final String LOGIN = "/jsp/login.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
		request.getRequestDispatcher(CADASTRO).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("post");	
		
		try {
			
			PrintWriter out = response.getWriter();
			ClienteDAO dao = new ClienteDAO();
			//recebendo valores da tela
			String nomeCliente = request.getParameter("nomeCliente");
			String email = request.getParameter("email");
		    String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String senhaconfir = request.getParameter("senhaconfir");
			String cpf = request.getParameter("cpf");
						
			//validando os valores recebidos
			if(senha != senhaconfir) {
				System.out.println("As senhas nao s�o iguais \n");
			}else {
				if (senha.isEmpty() || senhaconfir.isEmpty()) {
					System.out.println("O campo senha nao deve ficar em branco \n");
				}
			}
			
			//Validar cpf
			if(ValidarCPF.isCPF(cpf) == true) {
				System.out.printf("formato correto \n");
				//Valdiar se o cliente ja esta cadastrado
				EntidadeIN validaCliente = dao.consultarPorChavePrimaria(Cliente.class, cpf);
				
				if (validaCliente == null){
					Cliente cliente = new Cliente();
					cliente.setNomeCliente(nomeCliente);
					cliente.setEmail(email);
					cliente.setLogin(login);
					cliente.setSenha(senha);
					cliente.setCpf(cpf);
					//dao.inserir(cliente);
					RequestDispatcher rd = request.getRequestDispatcher(LOGIN);
					rd.forward(request,	response);
				}else {
					System.out.println("cpf ja existe" + cpf);
				}
			}else {
				out.print("formato invalido");
			}
			
			//testar
			System.out.println("Nome: " + nomeCliente);
			System.out.println("email: " + email);
			System.out.println("login: " + login);
			System.out.println("senha: " + senha);
			System.out.println("senhaconfir: " + senhaconfir);
			System.out.println("cpf: " + cpf);
			
		}catch (Exception e) {
			 
		}
	}

}
