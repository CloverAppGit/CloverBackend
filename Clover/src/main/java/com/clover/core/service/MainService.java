package com.clover.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.clover.core.model.ListItemModel;

public interface MainService
{
//	public List<EventoEntity> getEventos(long idUsuario, Pageable pageable);
	public List<ListItemModel> getEventos(long idUsuario, Pageable pageable);
}
