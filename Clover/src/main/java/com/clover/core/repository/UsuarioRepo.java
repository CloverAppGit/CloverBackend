package com.clover.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clover.core.entity.EventoEntity;
import com.clover.core.entity.UsuarioEntity;

@Repository("UsuarioRepo")
public interface UsuarioRepo extends JpaRepository<UsuarioEntity, Serializable>
{
	public abstract UsuarioEntity findByIdFacebook(long idFacebook);
	public abstract UsuarioEntity findByIdGoogle(long idGoogle);
//	public abstract List<UsuarioEntity> findByNombre(String nombre);
	
	public abstract Page<UsuarioEntity> findAll(Pageable pageable);

//  @Query("select u.eventos from UsuarioEntity u where u.idUsuario = ?1")
//	public abstract List<EventoEntity> findEventosByIdUsuario(long idUsuario, Pageable pageable);

	@Query("select ue.idUsuEven.usuario from UsuEvenEntity ue where ue.idUsuEven.evento.idEvento = ?1")
	public abstract List<UsuarioEntity> findUsuariosByIdEvento(long idEvento);
}
