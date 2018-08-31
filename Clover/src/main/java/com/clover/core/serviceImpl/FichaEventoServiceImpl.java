package com.clover.core.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.clover.core.entity.ActividadEntity;
import com.clover.core.entity.UsuarioEntity;
import com.clover.core.mapper.FichaEventoMapper;
import com.clover.core.repository.ActividadRepo;
import com.clover.core.repository.UsuarioRepo;
import com.clover.core.service.FichaEventoService;

@Service("FichaEventoService")
public class FichaEventoServiceImpl implements FichaEventoService
{
	@Autowired
	@Qualifier("UsuarioRepo")
	private UsuarioRepo usuarioRepo;
	
	@Autowired
	@Qualifier("ActividadRepo")
	private ActividadRepo actividadRepo;
	
	@Autowired
	private FichaEventoMapper fichaEventoMapper;
	
	private static final Log logger = LogFactory.getLog(FichaEventoService.class);

	@Override
	public Map<String, Object> getFichaEvento(long idEvento)
	{
		logger.info("Inicio getFichaEvento");
		try
		{
			Map<String, Object> fichaEvento = fichaEventoMapper.getGeneral(idEvento);
			List<Map<String, Object>> asistentes = fichaEventoMapper.getAsistentes(idEvento);
			List<Map<String, Object>> itinerario = fichaEventoMapper.getActividades(idEvento);
//			List<Map<String, Object>> rxData = (List<Map<String, Object>>) (List<?>) dataList;
//			List<Map<String, Object>> itinerario = (List<Map<String, Object>>) (List<?>) actividadRepo.findByIdEvento(idEvento);
			
			fichaEvento.put("asistentes", asistentes);
			fichaEvento.put("itinerario", itinerario);
			
			logger.info("Fin getFichaEvento");
			return fichaEvento;
		} catch (Exception ex)
		{
			return null;
		}
	}
}
