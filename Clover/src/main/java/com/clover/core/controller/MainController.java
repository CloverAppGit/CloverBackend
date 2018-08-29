package com.clover.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clover.core.model.ListItemModel;
import com.clover.core.serviceImpl.MainServiceImpl;
import com.clover.core.utils.JsonUtil;

@RestController
@RequestMapping("/main")
public class MainController
{
	@Autowired
	@Qualifier("MainService")
	private MainServiceImpl mainService;
	
	@GetMapping("/eventos/{idUsuario}")
	public ResponseEntity getEventos(@PathVariable("idUsuario") long idUsuario)
	{
		try
		{
//			List<EventoEntity> eventos =  mainService.getEventos(idUsuario, pageable);
			List<ListItemModel> eventos =  mainService.getEventos(idUsuario);
			String json = JsonUtil.toJson(eventos);

			return new ResponseEntity<String>(json, HttpStatus.OK);
		} catch (Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
