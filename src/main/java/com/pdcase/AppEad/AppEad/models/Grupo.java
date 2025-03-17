package com.pdcase.AppEad.AppEad.models;

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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
 
 
 
@Entity
public class Grupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_grupo;
	
	@NotEmpty
	private String nomeGrupo;
	
	@NotNull
	private LocalDate data_criacaoGrupo;
	
	@NotNull
	private LocalDateTime data_atualizacaoGrupo;
	
	@NotEmpty 
	private String descricaoGrupo;
	
	// Construtor padrão
				public Grupo() {
				    this.data_atualizacaoGrupo = LocalDateTime.now();
				}
	
	public String getDescricaoGrupo() {
		return descricaoGrupo;
	}

	public void setDescricaoGrupo(String descricaoGrupo) {
		this.descricaoGrupo = descricaoGrupo;
	}

	public LocalDateTime getData_atualizacaoGrupo() {
		return data_atualizacaoGrupo;
	}

	public void setData_atualizacaoGrupo(LocalDateTime data_atualizacaoGrupo) {
		this.data_atualizacaoGrupo = data_atualizacaoGrupo;
	}

	public void setId_grupo(long id_grupo) {
		this.id_grupo = id_grupo;
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public LocalDate getData_criacaoGrupo() {
		return data_criacaoGrupo;
	}

	public void setData_criacaoGrupo(LocalDate data_criacaoGrupo) {
		this.data_criacaoGrupo = data_criacaoGrupo;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Set<Projeto> getProjetos() {
		return projetos;
	}

	 public void setProjetos(Set<Projeto> projetos) {
		this.projetos = projetos;
	}

	public Set<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(Set<Aula> aulas) {
		this.aulas = aulas;
	}

	@OneToMany(mappedBy = "grupo", cascade = CascadeType.REMOVE)
	
	
	private List<Usuario> usuarios;
	
	@ManyToMany
    @JoinTable(
        name = "projeto_grupo",
        joinColumns = @JoinColumn(name = "id_grupo"),
        inverseJoinColumns = @JoinColumn(name = "id_projeto")
    )
	
    private Set<Projeto> projetos = new HashSet<>();
 
    @ManyToMany
    @JoinTable(
        name = "aula_grupo",
        joinColumns = @JoinColumn(name = "id_grupo"),
        inverseJoinColumns = @JoinColumn(name = "id_projeto")
    )
    
    private Set<Aula> aulas = new HashSet<>();
 
	public long getId_grupo() {
		return id_grupo;
	}
}