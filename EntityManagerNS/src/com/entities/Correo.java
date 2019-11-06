package com.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "correo", schema = "ProyectoDiseñoConceptual")
public class Correo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private int id; 
	private String cuerpo;
	private String subjeto;
	private Date lastSent;
	private int periodicidad;
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName="id")
	private Usuario usuario;
	
	@OneToMany (fetch = FetchType.EAGER, mappedBy="correoFrom", cascade = CascadeType.MERGE)
	private Set<Destinatario> destinatarios;
	
	
	public Correo() {
		this.setDestinatarios(new HashSet<Destinatario>());
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	public String getSubjeto() {
		return subjeto;
	}
	public void setSubjeto(String subjeto) {
		this.subjeto = subjeto;
	}
	public Date getLastSent() {
		return lastSent;
	}
	public void setLastSent(Date lastSent) {
		this.lastSent = lastSent;
	}
	public int getPeriodicidad() {
		return periodicidad;
	}
	public void setPeriodicidad(int periodicidad) {
		this.periodicidad = periodicidad;
	}
	public Set<Destinatario> getDestinatarios() {
		return destinatarios;
	}
	public void setDestinatarios(Set<Destinatario> destinatarios) {
		this.destinatarios = destinatarios;
	}
	public int getId() {
		return id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
