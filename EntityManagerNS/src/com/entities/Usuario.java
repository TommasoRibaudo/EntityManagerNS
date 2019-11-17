package com.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios", schema = "ProyectoDiseñoConceptual")
@NamedQueries (value = {
		@NamedQuery(
				name = "Usuario.findAll", 
				query = "SELECT u FROM Usuario u"),
		@NamedQuery(
				name = "Usuario.findOne", 
				query = "SELECT u FROM Usuario u WHERE u.id = :param ")
})
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int id; 
	private String correoUsuario;
	private String authId;
	private String contrasenna;
	@OneToMany (fetch = FetchType.EAGER, mappedBy="usuario", cascade = CascadeType.MERGE)
	private Set<Correo> correos;
	private String photoUrl;
	private String session;
	private String name;
	public Usuario() {
		this.setCorreos(new HashSet<Correo>());
	}
	public String getCorreoUsuario() {
		return correoUsuario;
	}
	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
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
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
