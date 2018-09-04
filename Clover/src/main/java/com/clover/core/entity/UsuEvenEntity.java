package com.clover.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "usu_even")
@Entity
public class UsuEvenEntity implements Serializable
{
	@Embeddable
	public static class UsuEvenEntityId implements Serializable
	{
		@ManyToOne
		@JoinColumn(name = "idUsuario", insertable = false, updatable = false)
		private UsuarioEntity usuario;

		@ManyToOne
		@JoinColumn(name = "idEvento", insertable = false, updatable = false)
		private EventoEntity evento;

		public UsuEvenEntityId()
		{

		}

		public UsuEvenEntityId(UsuarioEntity usuario, EventoEntity evento) 
		{
			this.usuario = usuario;
			this.evento = evento;
		}
	}

	@EmbeddedId
	private UsuEvenEntityId idUsuEven;
	
	@Column(name = "pagado")
	private boolean			pagado;

	// JPA
	public UsuEvenEntity()
	{

	}

	public UsuarioEntity getUsuario()
	{
		return idUsuEven.usuario;
	}

	public void setUsuario(UsuarioEntity usuario)
	{
		this.idUsuEven.usuario = usuario;
	}

	public EventoEntity getEvento()
	{
		return idUsuEven.evento;
	}

	public void setEvento(EventoEntity evento)
	{
		this.idUsuEven.evento = evento;
	}

	public boolean isPagado()
	{
		return pagado;
	}

	public void setPagado(boolean pagado)
	{
		this.pagado = pagado;
	}
}
