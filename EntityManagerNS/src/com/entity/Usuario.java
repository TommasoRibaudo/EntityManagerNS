package com.entity;

import java.util.Set;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios", schema = "ProyectoDiseñoConceptual")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int id; 
	private String correoUsuario;
	private int authId;
	private String contrasenna;
	@OneToMany (mappedBy="usuario", cascade = CascadeType.ALL)
	private Set<Correo> correos;
	
	
	public String getCorreoUsuario() {
		return correoUsuario;
	}
	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}
	public int getAuthId() {
		return authId;
	}
	public void setAuthId(int authId) {
		this.authId = authId;
	}
	public String getContrasenna() {
		return contrasenna;
	}
	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}
	public Set<Correo> getCorreos() {
		return correos;
	}
	public void setCorreos(Set<Correo> correos) {
		this.correos = correos;
	}
	public int getId() {
		return id;
	}

}
