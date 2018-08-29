package com.clover.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clover.core.service.GodService;

@RestController
@RequestMapping("/God")
public class GodController
{
	@Autowired
	@Qualifier("GodService")
	private GodService godService;
	
	@PutMapping("/StartUp")
	public boolean startUp()
	{
		return godService.startUp();
	}
	
	@PutMapping("/createEmpresas/{num}")
	public boolean createEmpresas(@PathVariable("num") int num)
	{
		return godService.createEmpresas(num);
	}
	
	@PutMapping("/createActividades/{num}")
	public boolean createActividades(@PathVariable("num") int num)
	{
		return godService.createActividades(num);
	}
	
	@PutMapping("/createUsuarios/{num}")
	public boolean createUsuarios(@PathVariable("num") int num)
	{
		return godService.createUsuarios(num);
	}
	
	@PutMapping("/createEventos/{num}")
	public boolean createEventos(@PathVariable("num") int num)
	{
		return godService.createEventos(num);
	}
	
	@PutMapping("/createUsuEven/{num}")
	public boolean createUsuEven(@PathVariable("num") int num)
	{
		return godService.createUsuEven(num);
	}
	
	@PutMapping("/createEvenAct/{num}")
	public boolean createEvenAct(@PathVariable("num") int num)
	{
		return godService.createEvenAct(num);
	}
}
