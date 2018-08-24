package com.clover.core.service;

import com.clover.core.entity.UsuarioEntity;
import com.clover.core.exceptions.CloverLoginException;

public interface LoginService
{
	public long logInFacebook(UsuarioEntity usuario) throws Exception;
	public UsuarioEntity logInGoogle(UsuarioEntity usuario) throws Exception;
}
