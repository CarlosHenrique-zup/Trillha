package br.com.zup.estrelas.cliente.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.estrelas.cliente.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

	Optional<Cliente> findByCpf(Long cpf);

//	boolean existByCpf(Long cpf);

	boolean deleteByCpf(Long cpf);

}
