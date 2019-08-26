package pe.com.reto.backend.intercorp.dev.model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class Kpi {
	
	@ApiModelProperty(notes = "Valor en decimal, con el fin de calcular el promedio de Edades")
	private BigDecimal promedio;
	@ApiModelProperty(notes = "Valor en decimal, con el fin de calcular la desviacion Estandar") 
	private BigDecimal desviacionEstandar;
	
	public Kpi() {
		super();
	}
	public Kpi(BigDecimal promedio, BigDecimal desviacionEstandar) {
		super();
		this.promedio = promedio;
		this.desviacionEstandar = desviacionEstandar;
	}
	public BigDecimal getPromedio() {
		return promedio;
	}
	public void setPromedio(BigDecimal promedio) {
		this.promedio = promedio;
	}
	public BigDecimal getDesviacionEstandar() {
		return desviacionEstandar;
	}
	public void setDesviacionEstandar(BigDecimal desviacionEstandar) {
		this.desviacionEstandar = desviacionEstandar;
	}
}
