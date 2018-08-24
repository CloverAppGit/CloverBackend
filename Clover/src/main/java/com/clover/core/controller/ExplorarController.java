package com.clover.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clover.core.serviceImpl.ExplorarServiceImpl;

@RestController
@RequestMapping("/Explorar")
public class ExplorarController
{
	@Autowired
	@Qualifier("ExplorarService")
	private ExplorarServiceImpl explorarService;

//	@GetMapping("/{tipo}/{page}")
//	public ResponseEntity getPropuesta(@PathVariable("tipo") int tipo, @PathVariable("page") int page)
//	{
//		try
//		{
//			Map<String, Object> propuesta = explorarService;
//			String json = JsonUtil.toJson(fichaEvento);
//
//			return new ResponseEntity<String>(json, HttpStatus.OK);
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		}
//	}
}
