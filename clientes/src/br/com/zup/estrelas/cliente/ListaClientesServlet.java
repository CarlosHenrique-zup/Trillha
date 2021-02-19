package br.com.zup.estrelas.cliente;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaClientes")
public class ListaClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		BancoDeDados banco = new BancoDeDados();
		List<Cliente> lista = banco.getCliente();
		
		request.setAttribute("cliente", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaClientes.jsp");
		rd.forward(request, response);
	}

}

