package com.pdcase.AppEad.AppEad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pdcase.AppEad.AppEad.models.Aula;
import com.pdcase.AppEad.AppEad.models.Projeto;
 
public interface AulaRepository extends CrudRepository<Aula, Long> {
 
    Iterable<Aula> findByProjeto(Projeto projeto);
 
    List<Aula> findByNomeAula(String nomeAula);
 
    @Query("SELECT a FROM Aula a WHERE a.id_aula = :id")
    Aula getById(@Param("id") long id);
}
