package com.clover.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.clover.core.model.ListItemModel;

@Mapper
public interface MainMapper
{
	List<ListItemModel> getEventos(@Param("idUsuario") long idUsuario);
}
