package br.com.zup.estrelas.cliente.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.cliente.dto.ClienteDTO;
import br.com.zup.estrelas.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.cliente.entity.Cliente;
import br.com.zup.estrelas.cliente.repository.ClienteRepository;
import br.com.zup.estrelas.cliente.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	private static final String CLIENTE_CADASTRADO_COM_SUCESSO = "Cliente cadastrado com sucesso!";
	private static final String CLIENTE_INEXISTENTE = "Cliente inexistente!";
	private static final String CLIENTE_REMOVIDO_COM_SUCESSO = "Cliente removido com sucesso!";
	private static final String CLIENTE_ALTERADO_COM_SUCESSO = "Cliente alterado com sucesso!";

	@Autowired
	ClienteRepository clienteRepository;

	public MensagemDTO adicionarCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();

		BeanUtils.copyProperties(clienteDTO, cliente);

		clienteRepository.save(cliente);

		return new MensagemDTO(CLIENTE_CADASTRADO_COM_SUCESSO);
	}

	public List<Cliente> listarCliente() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	public Cliente consultarPeloCpf(Long cpf) {
		return clienteRepository.findByCpf(cpf).orElse(null);
	}

	public MensagemDTO alterarCliente(Long cpf, ClienteDTO clienteDTO) {
		Optional<Cliente> clienteConsultado = clienteRepository.findByCpf(cpf);

		if (clienteConsultado.isEmpty()) {
			return new MensagemDTO(CLIENTE_INEXISTENTE);
		}

		Cliente clienteAlterado = clienteConsultado.get();
		BeanUtils.copyProperties(clienteDTO, clienteAlterado);

		clienteRepository.save(clienteAlterado);

		return new MensagemDTO(CLIENTE_ALTERADO_COM_SUCESSO);
	}

	public MensagemDTO removerCliente(Long cpf) {
		Optional<Cliente> clienteVerificado = clienteRepository.findByCpf(cpf);

        if (clienteVerificado.isEmpty()) {
            return new MensagemDTO(CLIENTE_INEXISTENTE);
        }

        clienteRepository.delete(clienteVerificado.get());
        return new MensagemDTO(CLIENTE_REMOVIDO_COM_SUCESSO);
        
	}

}
