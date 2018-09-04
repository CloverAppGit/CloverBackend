package com.clover.core.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "empresa")
@Entity
public class EmpresaEntity implements Serializable
{
	@Id
	@GeneratedValue
	@Column(name = "idEmpresa")
	private long idEmpresa;

	@Lob
	@Column(name = "picture")
	private byte[]				picture;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "direccion", length = 300)
	@Size(min = 0, max = 300)
	private String direccion;
	
	@Column(name = "lat")
	private double lat;
	
	@Column(name = "lon")
	private double lon;
	
//	@Column(name = "saludo", length = 300)
//	@Size(min = 0, max = 300)
//	private String saludo;
	
	@OneToMany(mappedBy = "empresa")
	@JsonIgnore
	private List<ActividadEntity> actividades;

	// JPA
	public EmpresaEntity()
	{
		
	}

	public long getIdEmpresa() 
	{
		return idEmpresa;
	}

	public void setIdEmpresa(long idEmpresa) 
	{
		this.idEmpresa = idEmpresa;
	}

	public byte[] getPicture()
	{
		return picture;
	}

	public void setPicture(byte[] picture)
	{
		this.picture = picture;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getDireccion() 
	{
		return direccion;
	}

	public void setDireccion(String direccion) 
	{
		this.direccion = direccion;
	}

	public double getLat()
	{
		return lat;
	}

	public void setLat(double lat)
	{
		this.lat = lat;
	}

	public double getLon()
	{
		return lon;
	}

	public void setLon(double lon)
	{
		this.lon = lon;
	}

//	public String getSaludo() 
//	{
//		return saludo;
//	}
//
//	public void setSaludo(String saludo) 
//	{
//		this.saludo = saludo;
//	}

	public List<ActividadEntity> getActividades() 
	{
		return actividades;
	}

	public void setActividades(List<ActividadEntity> actividades) 
	{
		this.actividades = actividades;
	}
}
