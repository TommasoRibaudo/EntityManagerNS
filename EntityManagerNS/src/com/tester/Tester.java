package com.tester;

import java.util.HashSet;
import java.util.List;

import com.entities.*;
import com.entityServices.*;

public class Tester {

	public static void main(String[] args) {
		Service md = new ServiceDestinatario();
		System.out.print("Starting...");
		md.startEntityManagerFactory();
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
		Destinatario d = (Destinatario) md.selectRegister(1);
				
		md.stopEntityManagerFactory();
		System.out.print("Done...");


	}

}
