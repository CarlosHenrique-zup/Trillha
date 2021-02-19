package br.com.zup.estrelas.cliente.service;

import java.util.List;

import br.com.zup.estrelas.cliente.dto.ClienteDTO;
import br.com.zup.estrelas.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.cliente.entity.Cliente;

public interface ClienteService {

	public MensagemDTO adicionarCliente(ClienteDTO clienteDTO);

	public MensagemDTO alterarCliente(Long cpf, ClienteDTO clienteDTO);

	public List<Cliente> listarCliente();

	public Cliente consultarPeloCpf(Long cpf);

	public MensagemDTO removerCliente(Long cpf);

}
