package com.pdcase.AppEad.AppEad.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_usuario;
	
	@NotEmpty
	private String nomeUsuario;
	
	@NotEmpty
	private String emailUsuario;
	
	@NotEmpty
	private String statusUsuario;
	
	@NotEmpty
	private String perfilUsuario;
	
	@NotNull
	private LocalDate data_nascimentoUsuario;
	
	@NotEmpty
	private String telefoneUsuario;
	
	@NotEmpty
	private String foto_perfilUsuario;
	
	@NotEmpty
	private String senhaUsuario;
	
	@NotNull
	private LocalDateTime data_criacaoUsuario;
	
	@NotNull
	private LocalDateTime data_atualizacaoUsuario;
	
	// Construtor padrão
	public Usuario() {
		this.data_criacaoUsuario = LocalDateTime.now();
	    this.data_atualizacaoUsuario = LocalDateTime.now();
	    this.statusUsuario = "";
	    this.perfilUsuario = "1";
	    this.telefoneUsuario = "1";
	    this.foto_perfilUsuario = "1";
	    this.senhaUsuario = "1";
	}
	
	

	public long getId_usuario() {
		return id_usuario;
	}



	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}



	public void setData_nascimentoUsuario(@NotNull LocalDate data_nascimentoUsuario) {
		this.data_nascimentoUsuario = data_nascimentoUsuario;
	}



	public LocalDate getData_nascimentoUsuario() {
		return data_nascimentoUsuario;
	}



	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getStatusUsuario() {
		return statusUsuario;
	}

	public void setStatusUsuario(String statusUsuario) {
		this.statusUsuario = statusUsuario;
	}

	public String getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(String perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}


	public String getTelefoneUsuario() {
		return telefoneUsuario;
	}

	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}

	public String getFoto_perfilUsuario() {
		return foto_perfilUsuario;
	}

	public void setFoto_perfilUsuario(String foto_perfilUsuario) {
		this.foto_perfilUsuario = foto_perfilUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public LocalDateTime getData_criacaoUsuario() {
		return data_criacaoUsuario;
	}

	public void setData_criacaoUsuario(LocalDateTime data_criacaoUsuario) {
		this.data_criacaoUsuario = data_criacaoUsuario;
	}

	public LocalDateTime getData_atualizacaoUsuario() {
		return data_atualizacaoUsuario;
	}

	public void setData_atualizacaoUsuario(LocalDateTime data_atualizacaoUsuario) {
		this.data_atualizacaoUsuario = data_atualizacaoUsuario;
	}
	
	@ManyToOne
    @JoinColumn(name = "id_grupo") // Chave estrangeira na tabela Grupo
    private Grupo grupo;

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	
	
}
