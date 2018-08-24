package com.clover.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.clover.core.entity.EventoEntity;

@Repository("EventoRepo")
public interface EventoRepo extends JpaRepository<EventoEntity, Serializable>
{
	public abstract EventoEntity findByIdEvento(long idEvento);
	public abstract List<EventoEntity> findByTitulo(String titulo);
	
	public abstract Page<EventoEntity> findAll(Pageable pageable);

	/*
	 * Obtiene los eventos de un usuario dado
	 */
//    @Query("select u.eventos from UsuarioEntity u where u.idUsuario = ?1")
    @Query("SELECT e FROM EventoEntity e WHERE e.idEvento IN (SELECT ue.idUsuEven.evento.idEvento FROM UsuEvenEntity ue WHERE ue.idUsuEven.usuario.idUsuario = ?1)")
	public abstract List<EventoEntity> findByIdUsuario(long idUsuario, Pageable pageable);

//	/*
//	 * Obtiene los eventos de un usuario dado
//	 */
//    @Query("select u.eventos from UsuarioEntity u where u.idUsuario = ?1")
//	public abstract List<EventoEntity> findByIdUsuario(long idUsuario, Pageable pageable);

//	/*
//	 * Obtiene los eventos paginados por tipo de evento
//	 */
//    @Query("select e from EventoEntity e where e.tipo = ?1")
//	public abstract List<EventoEntity> findByTipo(String tipo, Pageable pageable);

//	/*
//	 * Obtiene los eventos paginados por tipo de evento
//	 */
//    @Query("select e from EventoEntity e where e.tipo = ?1")
//	public abstract void asignar(long idUsuario, long idEvento);
    
}
