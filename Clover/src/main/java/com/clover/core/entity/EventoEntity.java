package com.clover.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private long idEvento;

    @ManyToOne
    @JoinColumn(name = "idPropuesta", nullable = false)
	@JsonIgnore
	private PropuestaEntity propuesta;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "fecha")
	private Date fecha;

	@OneToMany(mappedBy = "idUsuEven.evento")
	@JsonIgnore
	private List<UsuEvenEntity> usuarios;
	
	// JPA
	public EventoEntity()
	{
		
	}

	public EventoEntity(long idEvento, PropuestaEntity propuesta, String titulo, Date fecha, List<UsuEvenEntity> usuarios) 
	{
		this.idEvento = idEvento;
		this.propuesta = propuesta;
		this.titulo = titulo;
		this.fecha = fecha;
		this.usuarios = usuarios;
	}

	public long getIdEvento() 
	{
		return idEvento;
	}

	public void setIdEvento(long idEvento) 
	{
		this.idEvento = idEvento;
	}

	public PropuestaEntity getPropuesta()
	{
		return propuesta;
	}

	public void setPropuesta(PropuestaEntity propuesta)
	{
		this.propuesta = propuesta;
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
}
