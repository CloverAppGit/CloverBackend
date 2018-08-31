package com.clover.core.model.login;

import java.util.Date;
import java.util.List;

import com.clover.core.entity.UsuEvenEntity;

public class UsuarioModel
{
	private long				idUsuario;
	private long				idFacebook;
	private long				idGoogle;
	private Date				firstLogin;
	private Date				lastLogin;
	private String				nombre;
	private String				apellidos;
	private byte[]				picture;
	private List<UsuEvenEntity>	eventos;

	// JPA
	public UsuarioModel()
	{

	}

	public UsuarioModel(long idUsuario, long idFacebook, long idGoogle, Date lastLogin, String nombre,
			String apellidos, byte[] picture, List<UsuEvenEntity> eventos)
	{
		this.idUsuario = idUsuario;
		this.idFacebook = idFacebook;
		this.idGoogle = idGoogle;
		this.lastLogin = lastLogin;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.picture = picture;
		this.eventos = eventos;
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
