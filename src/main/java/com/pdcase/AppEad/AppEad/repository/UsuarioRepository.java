package com.pdcase.AppEad.AppEad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pdcase.AppEad.AppEad.models.Usuario;
import com.pdcase.AppEad.AppEad.models.Grupo;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
	
	Iterable<Usuario>findByGrupo(Grupo grupo);
	
	List<Usuario>findByNomeUsuario(String nomeUsuario);
	
	 @Query("SELECT u FROM Usuario u WHERE u.id_usuario = :id")
	    Usuario getById(@Param("id") long id);
}
