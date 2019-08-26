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
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pe.com.reto.backend.intercorp.dev.model.Cliente;
import pe.com.reto.backend.intercorp.dev.model.Kpi;
import pe.com.reto.backend.intercorp.dev.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClientesEndPoint {

	@Autowired
	private ClienteService iclienteService;

	@ApiOperation(value = "Operacion permite registrar un Nuevo Cliente")
	@ApiResponses(value = {			
			@ApiResponse(code = 200, message = "Registro ingresado correctamente"),
			@ApiResponse(code = 401, message = "Usted, no esta autorizado a realizar esta accion"),
			@ApiResponse(code = 403, message = "Esta prohibido realizar esta accion"),
			@ApiResponse(code = 404, message = "No es encuentra disponible esta accion") 
	})	
	@PostMapping("/crearcliente")
	public ResponseEntity crearCliente(@ApiParam(value = "Datos del Cliente requerido", required = true) @RequestBody Cliente icliente) {
		try {			
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

	@ApiOperation(value = "Operacion permite conocer la Desviacion Estandar, de los Clientes", response = Kpi.class)	
	@ApiResponses(value = {			
			@ApiResponse(code = 200, message = "Operacion realizada correctamente"),
			@ApiResponse(code = 401, message = "Usted, no esta autorizado a realizar esta accion"),
			@ApiResponse(code = 403, message = "Esta prohibido realizar esta accion"),
			@ApiResponse(code = 404, message = "No es encuentra disponible esta accion") 
	})
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

	@ApiOperation(value = "Operacion permite obtener un listado total de Cliente resgistrados", response = List.class)
	@ApiResponses(value = {			
			@ApiResponse(code = 200, message = "Lista recuperada correctamente"),
			@ApiResponse(code = 401, message = "Usted, no esta autorizado a realizar esta accion"),
			@ApiResponse(code = 403, message = "Esta prohibido realizar esta accion"),
			@ApiResponse(code = 404, message = "No es encuentra disponible esta accion") 
	})
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
