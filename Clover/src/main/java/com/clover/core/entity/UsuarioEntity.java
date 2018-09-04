package com.clover.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "usuario")
@Entity
public class UsuarioEntity implements Serializable
{

	@Id
	@GeneratedValue
	@Column(name = "idUsuario")
	private long				idUsuario;

	@Column(name = "idFacebook")
	private long				idFacebook;

	@Column(name = "idGoogle")
	private long				idGoogle;

	@Column(name = "firstLogin")
	private Date				firstLogin;

	@Column(name = "lastLogin")
	private Date				lastLogin;

	@Column(name = "nombre")
	private String				nombre;

	@Column(name = "apellidos")
	private String				apellidos;

	@Lob
	@Column(name = "picture")
	private byte[]				picture;

	@OneToMany(mappedBy = "idUsuEven.usuario")
	@JsonIgnore
	private List<UsuEvenEntity>	eventos;

	// JPA
	public UsuarioEntity()
	{

	}

	public long getIdUsuario()
	{
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario)
	{
		this.idUsuario = idUsuario;
	}

	public long getIdFacebook()
	{
		return this.idFacebook;
	}

	public void setIdFacebook(long idFacebook)
	{
		this.idFacebook = idFacebook;
	}

	public long getIdGoogle()
	{
		return this.idGoogle;
	}

	public void setIdGoogle(long idGoogle)
	{
		this.idGoogle = idGoogle;
	}

	public List<UsuEvenEntity> getEventos()
	{
		return eventos;
	}

	public void setEventos(List<UsuEvenEntity> eventos)
	{
		this.eventos = eventos;
	}

	public Date getLastLogin()
	{
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin)
	{
		this.lastLogin = lastLogin;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getApellidos()
	{
		return apellidos;
	}

	public void setApellidos(String apellidos)
	{
		this.apellidos = apellidos;
	}

	public byte[] getPicture()
	{
		return picture;
	}

	public void setPicture(byte[] picture)
	{
		this.picture = picture;
	}
}
