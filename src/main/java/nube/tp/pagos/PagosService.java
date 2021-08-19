package nube.tp.pagos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nube.tp.pagos.domains.Cliente;
import nube.tp.pagos.domains.EstadoCuenta;
import nube.tp.pagos.domains.Pago;
import nube.tp.pagos.domains.Pedido;
import nube.tp.pagos.repositories.ClienteRepository;
import nube.tp.pagos.repositories.DetallePedidoRepository;
import nube.tp.pagos.repositories.PedidoRepository;

@Service
public class PagosService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	DetallePedidoRepository detallePedidoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	public String pagar(Integer clienteId,Pago pago) {
		Cliente cliente = clienteRepository.findById(clienteId).get();
		cliente.pagos.add(pago);
		clienteRepository.save(cliente);
		return "Pago exitoso.";
	}

	public EstadoCuenta obtenerEstado(Integer clienteId) {
		EstadoCuenta estadoCuenta = new EstadoCuenta();
		Cliente cliente = clienteRepository.findById(clienteId).get();
		estadoCuenta.pagos = cliente.pagos;
		List<Pedido> pedidos = pedidoRepository.findByClienteId(clienteId);
		estadoCuenta.pedidos = pedidos;
		return estadoCuenta;
	}
}
