package com.clover.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clover.core.entity.ActividadEntity;
import com.clover.core.entity.EventoEntity;
import com.clover.core.serviceImpl.CrearEventoServiceImpl;
import com.clover.core.utils.JsonUtil;

@RestController
@RequestMapping("/crearEvento")
public class CrearEventoController
{
	@Autowired
	@Qualifier("ExplorarService")
	private CrearEventoServiceImpl crearEventoService;

	@GetMapping("/actividades/{tipo}")
	public ResponseEntity getActividades(@PathVariable("tipo") String tipo)
	{
		try
		{
			List<ActividadEntity> actividades = crearEventoService.getActividades(tipo);
			String json = JsonUtil.toJson(actividades);

			return new ResponseEntity<String>(json, HttpStatus.OK);
		} catch (Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

//	@PutMapping("/crear/{tipo}")
//	public ResponseEntity getActividades(@RequestBody @Valid EventoEntity eventoEntity)
//	{
//		try
//		{
//			List<ActividadEntity> actividades = crearEventoService.getActividades(tipo);
//			String json = JsonUtil.toJson(actividades);
//
//			return new ResponseEntity<String>(json, HttpStatus.OK);
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		}
//	}
}
