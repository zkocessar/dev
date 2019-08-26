package pe.com.reto.backend.intercorp.dev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import pe.com.reto.backend.intercorp.dev.model.Cliente;
import pe.com.reto.backend.intercorp.dev.model.Kpi;
import pe.com.reto.backend.intercorp.dev.services.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClientesEndPoint {
	
	@Autowired
	private ClienteService iclienteService;
	
	@ApiOperation(value = "Operacion permite registrar un Nuevo Cliente")
	@PostMapping("/crearcliente")
	public ResponseEntity crearCliente(@RequestBody Cliente icliente) {
		try {
			System.out.print(" -- > " + icliente.getC_nombre());
			int id = iclienteService.insertaCliente(icliente);
			
			if (id == 1) {
				return new ResponseEntity<>("Transacion Realizada con Existo", HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "Operacion permite conocer la Desviacion Estandar, de los Clientes")
	@GetMapping("/kpideclientes")
	public ResponseEntity<Kpi> kpiClientes() {
		try {
			Kpi ikpiResponse = iclienteService.calcularKpiCliente();
			return new ResponseEntity<>(ikpiResponse, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Kpi>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@ApiOperation(value = "Operacion permite obtener un listado total de Cliente resgistrados")
	@GetMapping("/listclientes")
	public ResponseEntity<List<Cliente>> listarClientes() {
		try {
			return new ResponseEntity<>(iclienteService.listarCliente(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Cliente>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
