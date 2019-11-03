package com.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity 
@Table(name = "destinatarios", schema = "ProyectoDiseñoConceptual")
@NamedQueries (value = {
		@NamedQuery(
				name = "Destinatario.findAll", 
				query = "SELECT d FROM Destinatario d"),
		@NamedQuery(
				name = "Destinatario.findOne", 
				query = "SELECT d FROM Destinatario d WHERE d.id = :param ")
})
public class Destinatario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private int id; 

	private String correoTo;
	
	@ManyToOne
	@JoinColumn(name = "id_correo", referencedColumnName="id")
	private Correo correoFrom;

	public int getId() {
		return id;
	}
	
	public String getCorreoTo() {
		return correoTo;
	}

	public void setCorreoTo(String correoTo) {
		this.correoTo = correoTo;
	}

	public Correo getCorreoFrom() {
		return correoFrom;
	}

	public void setCorreoFrom(Correo correoFrom) {
		this.correoFrom = correoFrom;
	}
}
