package com.clover.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "evento")
@Entity
public class EventoEntity implements Serializable
{
	@Id
	@GeneratedValue
	@Column(name = "idEvento")
	private long					idEvento;

	@Column(name = "titulo")
	private String					titulo;

	@Column(name = "fecha")
	private Date					fecha;

	@OneToMany(mappedBy = "idUsuEven.evento")
	@JsonIgnore
	private List<UsuEvenEntity>		usuarios;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "EvenAct", joinColumns = { @JoinColumn(name = "idEvento") }, inverseJoinColumns = {
			@JoinColumn(name = "idActividad") })
	@JsonIgnore
	private List<ActividadEntity>	actividades;

	// JPA
	public EventoEntity()
	{

	}

	public long getIdEvento()
	{
		return idEvento;
	}

	public void setIdEvento(long idEvento)
	{
		this.idEvento = idEvento;
	}

	public Date getFecha()
	{
		return fecha;
	}

	public void setFecha(Date fecha)
	{
		this.fecha = fecha;
	}

	public String getTitulo()
	{
		return titulo;
	}

	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}

	public List<UsuEvenEntity> getUsuarios()
	{
		return usuarios;
	}

	public void setUsuarios(List<UsuEvenEntity> usuarios)
	{
		this.usuarios = usuarios;
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
