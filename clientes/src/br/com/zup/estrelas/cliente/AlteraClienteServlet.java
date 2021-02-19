package br.com.zup.estrelas.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alteraCliente")
public class AlteraClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Alterando Cliente");

		String nomeCliente = request.getParameter("nome");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		System.out.println(id);

		BancoDeDados banco = new BancoDeDados();
		Cliente cliente = banco.buscaClientePeloId(id);
		cliente.setNome(nomeCliente);

		response.sendRedirect("listaClientes");
	}

}
