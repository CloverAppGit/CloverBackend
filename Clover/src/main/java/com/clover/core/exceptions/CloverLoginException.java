package com.clover.core.exceptions;

public class CloverLoginException extends Exception
{
	private static String errorMsg = "Error al acceder";
	
	public CloverLoginException ()
	{
		super(errorMsg);
	}
}
