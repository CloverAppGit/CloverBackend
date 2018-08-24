package com.clover.core.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "propuesta")
@Entity
public class PropuestaEntity implements Serializable
{
	@Id
	@GeneratedValue
	@Column(name = "idPropuesta")
	private long idPropuesta;
	
	@Column(name = "tipo", length = 1, nullable = false)
	private String tipo;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "PropuAct", joinColumns = {@JoinColumn(name = "idPropuesta")}, inverseJoinColumns = {@JoinColumn(name = "idActividad")})
	@JsonIgnore
	private List<ActividadEntity> actividades;
	
	// JPA
	public PropuestaEntity()
	{
		
	}

	public PropuestaEntity(long idPropuesta,  String tipo, List<ActividadEntity> actividades) 
	{
		this.idPropuesta = idPropuesta;
		this.tipo = tipo;
		this.actividades = actividades;
	}

	public long getIdPropuesta() 
	{
		return idPropuesta;
	}

	public void setIdPropuesta(long idPropuesta) 
	{
		this.idPropuesta = idPropuesta;
	}

	public String getTipo() 
	{
		return tipo;
	}

	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}

	public List<ActividadEntity> getActividades() 
	{
		return actividades;
	}

	public void setActividades(List<ActividadEntity> actividades) 
	{
		this.actividades = actividades;
	}
}
