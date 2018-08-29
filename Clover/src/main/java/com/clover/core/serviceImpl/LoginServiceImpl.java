package com.clover.core.serviceImpl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.clover.core.entity.UsuarioEntity;
import com.clover.core.exceptions.CloverLoginException;
import com.clover.core.repository.UsuarioRepo;
import com.clover.core.service.LoginService;

@Service("LoginService")
public class LoginServiceImpl implements LoginService
{

	@Autowired
	@Qualifier("UsuarioRepo")
	private UsuarioRepo usuarioRepo;
	
//	@PersistenceContext
//	private EntityManager em;
	
	private static final Log logger = LogFactory.getLog(LoginService.class);

	@Override
	public long logInFacebook(UsuarioEntity usuario) throws Exception
	{
		logger.info("Inicio logIn");
		
		UsuarioEntity u = usuarioRepo.findByIdFacebook(usuario.getIdFacebook());

		if (u == null)
		{
			u = new UsuarioEntity();
			u.setIdFacebook(usuario.getIdFacebook());
		}
		u.setNombre(usuario.getNombre());
		u.setApellidos(usuario.getApellidos());
		u.setPicture(usuario.getPicture());
		u.setLastLogin(new Date());
		
		usuarioRepo.save(u);
		
		logger.info("Fin logIn");
		return u.getIdUsuario();
	}

	@Override
	public UsuarioEntity logInGoogle(UsuarioEntity usuario) throws Exception
	{
		throw new CloverLoginException();
	}
}
