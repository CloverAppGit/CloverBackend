package com.clover.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.clover.core.entity.ActividadEntity;
import com.clover.core.entity.EventoEntity;

@Repository("ActividadRepo")
public interface ActividadRepo extends JpaRepository<ActividadEntity, Serializable>
{
	public abstract ActividadEntity findByIdActividad(long idActividad);
	
	public abstract Page<ActividadEntity> findAll(Pageable pageable);

	/*
	 * Obtiene las actividades por id de evento
	 */
    @Query("select e.actividades from EventoEntity e where e.idEvento = ?1")
	public abstract List<ActividadEntity> findByIdEvento(long idEvento);

	/*
	 * Obtiene las actividades por tipo
	 */
//    @Query("select a from ActividadEntity a where a.tipo = ?")
    public abstract List<ActividadEntity> findByTipo(String tipo);
}
