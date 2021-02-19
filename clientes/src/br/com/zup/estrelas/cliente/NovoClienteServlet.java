package br.com.zup.estrelas.cliente;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novoCliente")
public class NovoClienteServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Cadastrando novo cliente");
		
		String nomeCliente = request.getParameter("nome");
		
		Cliente cliente = new Cliente();
		cliente.setNome(nomeCliente);
		
		BancoDeDados banco = new BancoDeDados();
		banco.adicionaCliente(cliente);
		
		response.sendRedirect("listaClientes");
	}
}

