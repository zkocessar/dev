package pe.com.reto.backend.intercorp.dev.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.reto.backend.intercorp.dev.mappers.ClienteIMapper;
import pe.com.reto.backend.intercorp.dev.model.Cliente;
import pe.com.reto.backend.intercorp.dev.model.Kpi;


@Service
public class ClienteService {
	

	@Autowired
	private ClienteIMapper clienteIMapper;

	public Integer insertaCliente(Cliente iCliente) {
		try {
			return clienteIMapper.insert(iCliente);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}

	public Kpi calcularKpiCliente() {
		Kpi kpiRespuesta = new Kpi();
		try {
			// Promedio de Edades
			List<Cliente> iListReturn = clienteIMapper.findAll();
			Double calculoMedia = (double) (iListReturn.stream().mapToInt(i -> i.getC_edad()).sum()
					/ iListReturn.size());
			kpiRespuesta.setPromedio(new BigDecimal(calculoMedia));

			Double tmpDesviacion = new Double(0.0);
			//No use lambda, debido a que no me permite utilizar esta operacion "+="
			for (Cliente cliente : iListReturn) {
				if (cliente.getC_edad() != null) {
					tmpDesviacion += Math.pow((cliente.getC_edad() - calculoMedia), 2);
				}
			}

			Double disviacion = (tmpDesviacion / iListReturn.stream().filter(ele -> ele.getC_edad() != null).count());
			kpiRespuesta.setDesviacionEstandar(new BigDecimal(disviacion));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return kpiRespuesta;
	}

	public List<Cliente> listarCliente() {
		List<Cliente> iListReturn = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ahora = LocalDate.now();
		try {
			iListReturn = clienteIMapper.findAll();			
			iListReturn.stream().forEach(item -> {
				LocalDate fechaNac = LocalDate.parse(sdf.format(item.getC_fec_nav()), fmt);				
				Period periodo = Period.between(fechaNac, ahora);				
				if (periodo.getYears() > 60) {
					item.setC_fec_muerte(Date.from(ahora.plusMonths(1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
				}else {
					item.setC_fec_muerte(new Date("19/02/2035"));
				}				
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return iListReturn;

	}


	
}
