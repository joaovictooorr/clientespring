package br.com.cliente.demo.repository;

import br.com.cliente.demo.domain.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Long> {
}
