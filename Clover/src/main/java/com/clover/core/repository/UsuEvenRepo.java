package com.clover.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clover.core.entity.UsuEvenEntity;
import com.clover.core.entity.UsuarioEntity;

@Repository("UsuEvenRepo")
public interface UsuEvenRepo extends JpaRepository<UsuEvenEntity, Serializable>
{
//	public abstract UsuEvenEntity findByUsuario(UsuarioEntity usuario);
//	public abstract List<UsuarioEntity> findByNombre(String nombre);
	
//	public abstract Page<UsuarioEntity> findAll(Pageable pageable);
//
//    @Query("select u.eventos from UsuarioEntity u where u.idUsuario = ?1")
//	public abstract List<EventoEntity> findEventosByIdUsuario(long idUsuario, Pageable pageable);
}
