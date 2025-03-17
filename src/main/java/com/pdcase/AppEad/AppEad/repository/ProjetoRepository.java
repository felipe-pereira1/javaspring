package com.pdcase.AppEad.AppEad.repository;

import java.util.List;
 
import org.springframework.data.repository.CrudRepository;

import com.pdcase.AppEad.AppEad.models.Projeto;

 
public interface ProjetoRepository extends CrudRepository<Projeto, Long> {
	
	Projeto findById(long id);
	List<Projeto> findByNomeProjeto(String nomeProjeto);
	
}

