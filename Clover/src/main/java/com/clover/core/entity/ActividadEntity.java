package com.clover.core.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "actividad")
@Entity
public class ActividadEntity implements Serializable
{
	@Id
	@GeneratedValue
	@Column(name = "idActividad")
	private long					idActividad;

	@Column(name = "nombre")
	private String					nombre;

	@Column(name = "precio")
	private float					precio;
	
	//	R - Restaurantes, C - Clubs
	@Column(name = "tipo", length = 1, nullable = false)
	private String tipo;

	@ManyToOne
	@JoinColumn(name = "idEmpresa", nullable = false)
	@JsonIgnoreProperties("actividades")
	private EmpresaEntity			empresa;

	// JPA
	public ActividadEntity()
	{

	}

	public ActividadEntity(long idActividad, String nombre, String tipo, EmpresaEntity empresa)
	{
		this.idActividad = idActividad;
		this.nombre = nombre;
		this.tipo = tipo;
		this.empresa = empresa;
	}

	public long getIdActividad()
	{
		return idActividad;
	}

	public void setIdActividad(long idActividad)
	{
		this.idActividad = idActividad;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public float getPrecio()
	{
		return precio;
	}

	public void setPrecio(float precio)
	{
		this.precio = precio;
	}

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}

	public EmpresaEntity getEmpresa()
	{
		return empresa;
	}

	public void setEmpresa(EmpresaEntity empresa)
	{
		this.empresa = empresa;
	}
}
