package pe.com.reto.backend.intercorp.dev.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Detalles del Cliente")
@JsonInclude(Include.NON_NULL)
public class Cliente {
	
	@ApiModelProperty(notes = "Identificador unico, autogenerado por el Sistema", required = false)
	private Integer c_id;
	@ApiModelProperty(notes = "Nombre del Cliente")
	private String c_nombre;
	@ApiModelProperty(notes = "Apellido del Cliente")
	private String c_apellido;
	@ApiModelProperty(notes = "Edad del Cliente")
	private Integer c_edad;
	@ApiModelProperty(notes = "Fecha de Nacimiento del Cliente") 
	private Date c_fec_nav;
	@ApiModelProperty(notes = "Fecha de Muerte del Cliente" , required = false)
	private Date c_fec_muerte;

	public Cliente() {
		super();
	}

	public Cliente(Integer c_id, String c_nombre, String c_apellido, Integer c_edad, Date c_fec_nav) {
		super();
		this.c_id = c_id;
		this.c_nombre = c_nombre;
		this.c_apellido = c_apellido;
		this.c_edad = c_edad;
		this.c_fec_nav = c_fec_nav;
	}

	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public String getC_nombre() {
		return c_nombre;
	}

	public void setC_nombre(String c_nombre) {
		this.c_nombre = c_nombre;
	}

	public String getC_apellido() {
		return c_apellido;
	}

	public void setC_apellido(String c_apellido) {
		this.c_apellido = c_apellido;
	}

	public Integer getC_edad() {
		return c_edad;
	}

	public void setC_edad(Integer c_edad) {
		this.c_edad = c_edad;
	}

	public Date getC_fec_nav() {
		return c_fec_nav;
	}

	public void setC_fec_nav(Date c_fec_nav) {
		this.c_fec_nav = c_fec_nav;
	}

	public Date getC_fec_muerte() {
		return c_fec_muerte;
	}

	public void setC_fec_muerte(Date c_fec_muerte) {
		this.c_fec_muerte = c_fec_muerte;
	}
	
}
