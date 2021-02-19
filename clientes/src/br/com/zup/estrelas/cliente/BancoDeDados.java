package br.com.zup.estrelas.cliente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BancoDeDados {

	private static List<Cliente> listaCliente = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Cliente cliente = new Cliente();
		cliente.setId(chaveSequencial++);
		cliente.setNome("Cleiton");
		cliente.setEmail("cleiton2020@gmail.com");
		cliente.setIdade(40);
		cliente.setTelefone("20230120");
		cliente.setCpf("0394044");
		
		Cliente cliente1 = new Cliente();
		cliente1.setId(chaveSequencial++);
		cliente1.setNome("Cleiton");
		cliente1.setEmail("cleiton2020@gmail.com");
		cliente1.setIdade(40);
		cliente1.setTelefone("20230120");
		cliente1.setCpf("0394044");
		
		listaCliente.add(cliente);
		listaCliente.add(cliente1);
	}
	
	public void adicionaCliente(Cliente cliente) {
		cliente.setId(BancoDeDados.chaveSequencial++);
		BancoDeDados.listaCliente.add(cliente);
	}
	
	public List<Cliente> getCliente(){
		return BancoDeDados.listaCliente;
	}
	
	public Cliente buscaClientePeloId(Integer id) {
		for(Cliente cliente : listaCliente) {
			if(cliente.getId() == id) {
				return cliente;
			}
		}
		
		return null;
	}
	
	public void removeCliente(Integer id) {
		
		Iterator<Cliente> it = listaCliente.iterator();
		
		while(it.hasNext()) {
			Cliente clientes = it.next();
			if(clientes.getId() == id){
				it.remove();
			}
		}
	}
	
}
