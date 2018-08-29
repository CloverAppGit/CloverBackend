package com.clover.core.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clover.core.entity.ActividadEntity;
import com.clover.core.entity.UsuarioEntity;
import com.clover.core.serviceImpl.FichaEventoServiceImpl;
import com.clover.core.utils.JsonUtil;

@RestController
@RequestMapping("/fichaEvento")
public class FichaEventoController
{
	@Autowired
	@Qualifier("FichaEventoService")
	private FichaEventoServiceImpl fichaEventoService;

	@GetMapping("/{idEvento}")
	public ResponseEntity getFichaEvento(@PathVariable("idEvento") long idEvento)
	{
		try
		{
			Map<String, Object> fichaEvento = fichaEventoService.getFichaEvento(idEvento);
			String json = JsonUtil.toJson(fichaEvento);//.replace("[", "").replace("]", "");

			return new ResponseEntity<String>(json, HttpStatus.OK);
		} catch (Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
