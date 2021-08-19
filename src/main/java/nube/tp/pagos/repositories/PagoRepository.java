package nube.tp.pagos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nube.tp.pagos.domains.Pago;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
}
