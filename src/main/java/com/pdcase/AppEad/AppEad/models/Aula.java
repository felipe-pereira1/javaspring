package com.pdcase.AppEad.AppEad.models;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Aula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_aula;
	
	@NotEmpty
	private String linkAula;
	
	@NotEmpty
	private String nomeAula;
	
	@NotNull
	private String descricaoAula;
	
	@NotNull
	private LocalDate data_criacaoAula;
	
	@NotNull
	private LocalDateTime data_atualizacaoAula;
	
	// Construtor padrão
				public Aula() {
				    this.data_atualizacaoAula = LocalDateTime.now();
				    this.duracaoAula = "";
				    this.descricaoAula ="";
				}
	
	@NotEmpty
	private String duracaoAula;
	
	@NotNull
	private String statusAula;
	
	

	public long getId_aula() {
		return id_aula;
	}

	public void setId_aula(long id_aula) {
		this.id_aula = id_aula;
	}

	public String getLinkAula() {
		return linkAula;
	}

	public void setLinkAula(String linkAula) {
		this.linkAula = linkAula;
	}

	public String getNomeAula() {
		return nomeAula;
	}

	public void setNomeAula(String nomeAula) {
		this.nomeAula = nomeAula;
	}

	public String getDescricaoAula() {
		return descricaoAula;
	}

	public void setDescricaoAula(String descricaoAula) {
		this.descricaoAula = descricaoAula;
	}

	public LocalDate getData_criacaoAula() {
		return data_criacaoAula;
	}

	public void setData_criacaoAula(LocalDate data_criacaoAula) {
		this.data_criacaoAula = data_criacaoAula;
	}

	public LocalDateTime getData_atualizacaoAula() {
		return data_atualizacaoAula;
	}

	public void setData_atualizacaoAula(LocalDateTime data_atualizacaoAula) {
		this.data_atualizacaoAula = data_atualizacaoAula;
	}

	public String getDuracaoAula() {
		return duracaoAula;
	}

	public void setDuracaoAula(String duracaoAula) {
		this.duracaoAula = duracaoAula;
	}

	public String getStatusAula() {
		return statusAula;
	}

	public void setStatusAula(String statusAula) {
		this.statusAula = statusAula;
	}

	
	@ManyToOne
    @JoinColumn(name = "id_projeto") // Chave estrangeira na tabela Aula
    private Projeto projeto;
	
	

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}


	@ManyToMany(mappedBy = "aulas")
    private Set<Grupo> grupos = new HashSet<>();

	public Set<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(Set<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	
}
