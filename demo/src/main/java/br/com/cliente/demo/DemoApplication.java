package br.com.cliente.demo;

import br.com.cliente.demo.domain.Cliente;
import br.com.cliente.demo.repository.IClienteRepository;
import jakarta.persistence.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.cliente.demo.repository")
@ComponentScan(basePackages = "br.com.cliente")
public class DemoApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@Autowired
	private IClienteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("StartApplication...");
		Cliente cliente = createCliente();
		repository.save(cliente);
	}

	private Cliente createCliente() {
		return Cliente.builder()
				.cpf(12312312310L)
				.nome("Teste Spring Boot")
				.tel(10203040L)
				.build();
	}


}
