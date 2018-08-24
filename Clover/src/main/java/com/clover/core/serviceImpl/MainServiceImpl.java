package com.clover.core.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clover.core.mapper.MainMapper;
import com.clover.core.model.ListItemModel;
import com.clover.core.repository.EventoRepo;
import com.clover.core.service.MainService;

@Service("MainService")
public class MainServiceImpl implements MainService
{
	@Autowired
	@Qualifier("EventoRepo")
	private EventoRepo eventoRepo;
	
	@Autowired
	private MainMapper mainMapper;
	
//	@PersistenceContext
//	private EntityManager em;
	
	private static final Log logger = LogFactory.getLog(MainService.class);

//	@Override
//	public List<EventoEntity> getEventos(long idUsuario, Pageable pageable)
//	{
//		return eventoRepo.findByIdUsuario(idUsuario, pageable);
//	}

	@Override
	public List<ListItemModel> getEventos(long idUsuario, Pageable pageable)
	{
		List<ListItemModel> items = mainMapper.getEventos(idUsuario);
		
		return items;
	}
}
