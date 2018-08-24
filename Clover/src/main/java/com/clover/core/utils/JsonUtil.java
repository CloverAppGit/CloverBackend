package com.clover.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil
{

	public static String toJson(Object o) throws JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(o);
	}
}
