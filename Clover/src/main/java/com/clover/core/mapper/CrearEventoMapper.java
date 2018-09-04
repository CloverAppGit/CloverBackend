package com.clover.core.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CrearEventoMapper
{
	List<Map<String, Object>> getActividades(@Param("tipo") String tipo);
}
