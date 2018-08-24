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

	@ManyToOne
	@JoinColumn(name = "idEmpresa", nullable = false)
	@JsonIgnoreProperties("actividades")
	private EmpresaEntity			empresa;

	@ManyToMany(cascade = { CascadeType.ALL }, mappedBy = "actividades")
	@JsonIgnore
	private List<PropuestaEntity>	propuestas;

	// JPA
	public ActividadEntity()
	{

	}

	public ActividadEntity(long idActividad, String nombre, EmpresaEntity empresa, List<PropuestaEntity> propuestas)
	{
		this.idActividad = idActividad;
		this.nombre = nombre;
		this.empresa = empresa;
		this.propuestas = propuestas;
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

	public EmpresaEntity getEmpresa()
	{
		return empresa;
	}

	public void setEmpresa(EmpresaEntity empresa)
	{
		this.empresa = empresa;
	}

	public float getPrecio()
	{
		return precio;
	}

	public void setPrecio(float precio)
	{
		this.precio = precio;
	}

	public List<PropuestaEntity> getPropuestas()
	{
		return propuestas;
	}

	public void setPropuestas(List<PropuestaEntity> propuestas)
	{
		this.propuestas = propuestas;
	}
}
