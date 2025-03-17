package com.pdcase.AppEad.AppEad.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pdcase.AppEad.AppEad.models.Grupo;

 
public interface GrupoRepository extends CrudRepository<Grupo, Long> {
	
	Grupo findById(long id);
	List<Grupo> findByNomeGrupo(String nomeGrupo);
	
}
