package com.clover.core.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "direccion", length = 300)
	@Size(min = 0, max = 300)
	private String direccion;
	
	@Column(name = "saludo", length = 300)
	@Size(min = 0, max = 300)
	private String saludo;
	
	@OneToMany(mappedBy = "empresa")
	@JsonIgnore
	private List<ActividadEntity> actividades;

	// JPA
	public EmpresaEntity()
	{
		
	}

	public EmpresaEntity(long idEmpresa, String nombre, String direccion, String saludo, List<ActividadEntity> actividades) 
	{
		this.idEmpresa = idEmpresa;
		this.nombre = nombre;
		this.direccion = direccion;
		this.saludo = saludo;
		this.actividades = actividades;
	}

	public long getIdEmpresa() 
	{
		return idEmpresa;
	}

	public void setIdEmpresa(long idEmpresa) 
	{
		this.idEmpresa = idEmpresa;
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

	public String getSaludo() 
	{
		return saludo;
	}

	public void setSaludo(String saludo) 
	{
		this.saludo = saludo;
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
