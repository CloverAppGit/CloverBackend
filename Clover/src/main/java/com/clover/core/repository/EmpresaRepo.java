package com.clover.core.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.clover.core.entity.EmpresaEntity;

@Repository("EmpresaRepo")
public interface EmpresaRepo extends JpaRepository<EmpresaEntity, Serializable>
{
	public abstract EmpresaEntity findByIdEmpresa(long idEmpresa);
	
	public abstract Page<EmpresaEntity> findAll(Pageable pageable);
}
