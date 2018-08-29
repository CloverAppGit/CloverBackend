package com.clover.core.serviceImpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.clover.core.entity.ActividadEntity;
import com.clover.core.repository.ActividadRepo;
import com.clover.core.service.CrearEventoService;

@Service("ExplorarService")
public class CrearEventoServiceImpl implements CrearEventoService
{
	@Autowired
	@Qualifier("ActividadRepo")
	private ActividadRepo actividadRepo;
	
	private static final Log logger = LogFactory.getLog(CrearEventoService.class);

	@Override
	public List<ActividadEntity> getActividades(String tipo)
	{
		List<ActividadEntity> actividades = actividadRepo.findByTipo(tipo);
		
		return actividades;
	}
}
