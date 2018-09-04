package com.clover.core.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clover.core.entity.ActividadEntity;
import com.clover.core.mapper.CrearEventoMapper;
import com.clover.core.service.CrearEventoService;

@Service("CrearEventoService")
public class CrearEventoServiceImpl implements CrearEventoService
{
//	@Autowired
//	@Qualifier("ActividadRepo")
//	private ActividadRepo actividadRepo;
	
	@Autowired
	private CrearEventoMapper crearEventoMapper;
	
	private static final Log logger = LogFactory.getLog(CrearEventoService.class);

	@Override
	public List<Map<String, Object>> getActividades(String tipo)
	{
		List<Map<String, Object>> actividades = crearEventoMapper.getActividades(tipo);
		
		return actividades;
	}
}
