package com.tester;

import java.util.HashSet;
import java.util.List;

import com.entities.*;
import com.entityServices.*;

public class Tester {

	public static void main(String[] args) {
		Service md = new ServiceUsuario();
		System.out.print("Starting...");
		
		
		 	/*Destinatario d= new Destinatario();
		 	d.setCorreoTo("mynew@correo.com");
			Correo c = new Correo ();
			c.setCuerpo("rrr");
			c.setDestinatarios(new HashSet<Destinatario>());
			c.getDestinatarios().add(d);
			d.setCorreoFrom(c);
			// Insertar
			md.getEm().getTransaction().begin();
			md.getEm().persist(c);
			md.getEm().getTransaction().commit();
		System.out.print("Stopping...");

		List<Destinatario> dl = (List<Destinatario>) md.selectAll();
		
		for (Destinatario d:dl)
		{
			System.out.print(d.getCorreoTo());
		}*/
		Usuario usuario = new Usuario();
		usuario.setAuthId("321123");
		usuario.setCorreoUsuario("11223");
		md.insert(usuario);		
		
		System.out.print("Done...");


	}

}
