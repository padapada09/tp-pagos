package nube.tp.pagos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nube.tp.pagos.domains.EstadoCuenta;
import nube.tp.pagos.domains.Pago;

@RestController
@RequestMapping("/api/pagos")
public class PagosController {

	@Autowired
	PagosService pagosService;

	@PostMapping("/{clienteId}/pagar")
    public ResponseEntity<String> pagar(@PathVariable Integer clienteId, @RequestBody Pago pago) throws ControllerException {
        return new ResponseEntity<>(pagosService.pagar(clienteId,pago), HttpStatus.OK);
    }

	@GetMapping("/{clienteId}")
    public ResponseEntity<EstadoCuenta> obtenerEstado(@PathVariable Integer clienteId) throws ControllerException {
        return new ResponseEntity<>(pagosService.obtenerEstado(clienteId), HttpStatus.OK);
    }
}