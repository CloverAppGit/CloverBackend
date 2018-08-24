package com.clover.core.model;

import java.util.Date;

public class ListItemModel
{
	private long	id;
	private String	titulo;
	private Date	fecha;

	public ListItemModel()
	{

	}

	public ListItemModel(long id, String titulo, Date fecha)
	{
		this.id = id;
		this.titulo = titulo;
		this.fecha = fecha;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getTitulo()
	{
		return titulo;
	}

	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}

	public Date getFecha()
	{
		return fecha;
	}

	public void setFecha(Date fecha)
	{
		this.fecha = fecha;
	}
}
