package com.clover.core.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clover.core.entity.UsuarioEntity;
import com.clover.core.serviceImpl.LoginServiceImpl;
import com.clover.core.utils.JsonUtil;

@RestController
@RequestMapping("/login")
public class LoginController
{
	@Autowired
	@Qualifier("LoginService")
	private LoginServiceImpl loginService;

	@PutMapping("/facebook")
	public ResponseEntity logInFacebook(@RequestBody @Valid UsuarioEntity usuarioEntity)
	{
		try
		{
			long idUsuario = loginService.logInFacebook(usuarioEntity);
			String json = JsonUtil.toJson(idUsuario);

			return new ResponseEntity<String>(json, HttpStatus.OK);
		} catch (Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/login.html")
    String getView(Model model) {
        model.addAttribute("msg", "Hello there, This message has been injected from the controller method");
        return "helloWorld";
    }

//	@PutMapping("/google")
//	public ResponseEntity logInGoogle(@RequestBody @Valid UsuarioEntity usuarioEntity)
//	{
//		try
//		{
//			UsuarioEntity usuario = loginService.logInGoogle(usuarioEntity);
//			String json = JsonUtil.toJson(usuario);
//
//			return new ResponseEntity<String>(json, HttpStatus.OK);
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		}
//	}
}
