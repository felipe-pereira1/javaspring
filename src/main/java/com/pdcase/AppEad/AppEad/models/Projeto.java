package com.pdcase.AppEad.AppEad.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Projeto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_projeto;
	
	@NotEmpty
	private String nomeProjeto;
	
	@NotEmpty
	private String descricaoProjeto;
	
	@NotNull
	private LocalDate data_criacaoProjeto;
	
	@NotNull
	private LocalDateTime data_atualizacaoProjeto;
	
	// Construtor padrão
			public Projeto() {
			    this.data_atualizacaoProjeto = LocalDateTime.now();
			}
	
	@NotEmpty
	private String statusProjeto;


	public long getId_projeto() {
		return id_projeto;
	}





	public void setId_projeto(long id_projeto) {
		this.id_projeto = id_projeto;
	}





	public String getNomeProjeto() {
		return nomeProjeto;
	}





	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}





	public String getDescricaoProjeto() {
		return descricaoProjeto;
	}





	public void setDescricaoProjeto(String descricaoProjeto) {
		this.descricaoProjeto = descricaoProjeto;
	}

	

	public LocalDate getData_criacaoProjeto() {
		return data_criacaoProjeto;
	}





	public void setData_criacaoProjeto(LocalDate data_criacaoProjeto) {
		this.data_criacaoProjeto = data_criacaoProjeto;
	}





	public LocalDateTime getData_atualizacaoProjeto() {
		return data_atualizacaoProjeto;
	}





	public void setData_atualizacaoProjeto(LocalDateTime data_atualizacaoProjeto) {
		this.data_atualizacaoProjeto = data_atualizacaoProjeto;
	}




	public String getStatusProjeto() {
		return statusProjeto;
	}





	public void setStatusProjeto(String statusProjeto) {
		this.statusProjeto = statusProjeto;
	}





	public List<Aula> getAulas() {
		return aulas;
	}





	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}





	@OneToMany(mappedBy = "projeto", cascade = CascadeType.REMOVE)
	private List<Aula> aulas;
	
	@ManyToMany(mappedBy = "projetos")
    private Set<Grupo> grupos = new HashSet<>();





	public Set<Grupo> getGrupos() {
		return grupos;
	}


	public void setGrupos(Set<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	
}
