package nube.tp.pagos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nube.tp.pagos.domains.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
