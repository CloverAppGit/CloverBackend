package com.clover.core.service;

import java.util.List;

import com.clover.core.entity.ActividadEntity;

public interface CrearEventoService
{
	public List<ActividadEntity> getActividades(String tipo);
}
