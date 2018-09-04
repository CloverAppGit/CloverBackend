package com.clover.core.serviceImpl;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.clover.core.entity.ActividadEntity;
import com.clover.core.entity.EmpresaEntity;
import com.clover.core.entity.EventoEntity;
import com.clover.core.entity.UsuEvenEntity;
import com.clover.core.entity.UsuarioEntity;
import com.clover.core.repository.ActividadRepo;
import com.clover.core.repository.EmpresaRepo;
import com.clover.core.repository.EventoRepo;
import com.clover.core.repository.UsuEvenRepo;
import com.clover.core.repository.UsuarioRepo;
import com.clover.core.service.GodService;

@Service("GodService")
public class GodServiceImpl implements GodService
{
	@Autowired
	@Qualifier("UsuarioRepo")
	private UsuarioRepo usuarioRepo;

	@Autowired
	@Qualifier("EventoRepo")
	private EventoRepo eventoRepo;

	@Autowired
	@Qualifier("UsuEvenRepo")
	private UsuEvenRepo usuEvenRepo;

	@Autowired
	@Qualifier("ActividadRepo")
	private ActividadRepo actividadRepo;

	@Autowired
	@Qualifier("EmpresaRepo")
	private EmpresaRepo empresaRepo;
	
	private static final Log logger = LogFactory.getLog(GodService.class);

	@Override
	public boolean startUp()
	{
		try
		{
			logger.debug("Inicio Start Up");

			createEmpresas(5);
			createActividades(15);
			createEventos(10);
//			createEvenAct(15);
//			createUsuarios(40);
//			createUsuEven(15);
			
			logger.debug("Fin Start Up");
			return true;
		} catch (Exception ex)
		{
			return false;
		}
	}

	@Override
	public boolean createEmpresas(int n)
	{
		try
		{
			logger.debug("Inicio Create Empresas");
			long empresas = empresaRepo.findAll().size();
			
			EmpresaEntity entity = null;
			for (long i = empresas + 1; i < empresas + 1 + n; i++)
			{
				entity = new EmpresaEntity();
				entity.setNombre("Empresa " + i);
				empresaRepo.save(entity);
			}
			logger.debug("Fin Create Empresas");
			return true;
		} catch (Exception ex)
		{
			return false;
		}
	}

	@Override
	public boolean createActividades(int n)
	{
		try
		{
			logger.debug("Inicio Create Actividades");
			long count = actividadRepo.findAll().size();
			
			ActividadEntity entity = null;
			for (long i = count + 1; i < count + 1 + n; i++)
			{
				entity = new ActividadEntity();
				entity.setNombre("Actividad " + i);
				
				EmpresaEntity empresa = empresaRepo.findAll().get((int)(Math.random() * (empresaRepo.findAll().size() - 1)));
				
				entity.setEmpresa(empresa);
				entity.setPrecio((float)(Math.random() * 15.75));
				
				int tipo = (int)(Math.random() * 2);
				if (tipo == 0)
				{
					entity.setTipo("R");
				}
				else
				{
					entity.setTipo("C");
				}
				
				actividadRepo.save(entity);
			}
			logger.debug("Fin Create Actividades");
			return true;
		} catch (Exception ex)
		{
			return false;
		}
	}

	@Override
	public boolean createEventos(int n)
	{
		try
		{
			logger.debug("Inicio Create Eventos");
			long eventos = eventoRepo.findAll().size();
			
			EventoEntity entity = null;
			for (long i = eventos + 1; i < eventos + 1 + n; i++)
			{
				entity = new EventoEntity();
				entity.setTitulo("Evento " + i);
				entity.setFecha(new Date());
				
				eventoRepo.save(entity);
			}
			logger.debug("Fin Create Eventos");
			return true;
		} catch (Exception ex)
		{
			return false;
		}
	}

	@Override
	public boolean createUsuarios(int n)
	{
		try
		{
			logger.debug("Inicio Create Usuarios");
			long usuarios = eventoRepo.findAll().size();
			
			UsuarioEntity entity = null;
			for (long i = usuarios + 1; i < usuarios + 1 + n; i++)
			{
				entity = new UsuarioEntity();
				entity.setIdFacebook((int)(Math.random() * 1943465));
				entity.setIdGoogle((int)(Math.random() * 1943278));
				entity.setLastLogin(new Date());
				
				usuarioRepo.save(entity);
			}
			logger.debug("Fin Create Usuarios");
			return true;
		} catch (Exception ex)
		{
			return false;
		}
	}

	@Override
	public boolean createUsuEven(int n)
	{
		try
		{
			logger.debug("Inicio Create UsuEven");
			
			UsuarioEntity u = null;
			EventoEntity e = null;
			for (long i = 0; i < n; i++)
			{
				UsuarioEntity usuario = usuarioRepo.findAll().get((int)(Math.random() * (usuarioRepo.findAll().size() - 1)));
				EventoEntity evento = eventoRepo.findAll().get((int)(Math.random() * (eventoRepo.findAll().size() - 1)));

				UsuEvenEntity ue = new UsuEvenEntity();
				ue.setUsuario(usuario);
				ue.setEvento(evento);
				ue.setPagado(false);
				
				usuEvenRepo.save(ue);
			}
			logger.debug("Fin Create Eventos");
			return true;
		} catch (Exception ex)
		{
			return false;
		}
	}

	@Override
	public boolean createEvenAct(int n)
	{
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public boolean startUpSession()
//	{
//		try
//		{
//			logger.debug("Inicio Start Up");
//			
//			Session session = HibernateUtil.getSessionFactory().openSession();
//			session.beginTransaction();
//			
//			UsuarioEntity u = new UsuarioEntity(99999, new Date());
//			session.save(u);
//			
//			session.getTransaction().commit();
//			
//			logger.debug("Fin Start Up");
//			return true;
//		} catch (Exception ex)
//		{
//			return false;
//		}
//	}
}
