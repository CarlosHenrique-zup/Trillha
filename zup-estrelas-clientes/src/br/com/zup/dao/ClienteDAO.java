package br.com.zup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.com.zup.pojo.Cliente;

public class ClienteDAO {

	EntityManager manager;

	public ClienteDAO() {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("pecas");
		this.manager = managerFactory.createEntityManager();
		System.out.println("Conectado");
	}

	public void cadastrarNovoCliente(Cliente cliente) {
		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();
	}

	public Cliente consultaClientePeloId(Long idCliente) {
		Cliente clienteConsultado = manager.find(Cliente.class, idCliente);
		return clienteConsultado;
	}

	public List<Cliente> consultaTodosOsClientes() {
		Query queryCliente = manager.createQuery("select c from Cliente as c");

		List<Cliente> clientes = queryCliente.getResultList();

		return clientes;
	}

	public void atualizarCliente(Cliente cliente, Long idCliente) {
		Cliente clienteAlterado = manager.find(Cliente.class, idCliente);
		
		try {
			clienteAlterado.setNome(cliente.getNome());
			clienteAlterado.setEmail(cliente.getEmail());
			clienteAlterado.setCpf(cliente.getCpf());
			clienteAlterado.setEndereco(cliente.getEndereco());
			clienteAlterado.setIdade(cliente.getIdade());
			clienteAlterado.setTelefone(cliente.getTelefone());

			manager.getTransaction().begin();
			manager.merge(clienteAlterado);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void removerCliente(Long idCliente) {
		Cliente cliente = manager.find(Cliente.class, idCliente);

		manager.getTransaction().begin();
		manager.remove(cliente);
		manager.getTransaction().commit();
	}
}
