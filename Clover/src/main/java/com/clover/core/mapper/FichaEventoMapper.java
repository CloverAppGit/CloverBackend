package com.clover.core.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FichaEventoMapper
{
	Map<String, Object> getGeneral(@Param("idEvento") long idEvento);
	List<Map<String, Object>> getAsistentes(@Param("idEvento") long idEvento);
	List<Map<String, Object>> getActividades(@Param("idEvento") long idEvento);
}
