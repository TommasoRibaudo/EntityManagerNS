package com.entityServices;

import java.util.List;

import javax.persistence.TypedQuery;

import com.entities.Destinatario;
import com.entities.Usuario;

@SuppressWarnings("finally")
public class ServiceUsuario extends Service{
	private TypedQuery<Usuario> query;
	private Usuario usuario;

	@Override
	public List<Usuario> selectAll() {
		try {
			this.startEntityManagerFactory();
			this.query = this.getEm().createNamedQuery("Usuario.findAll", Usuario.class);
			return query.getResultList();
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			this.stopEntityManagerFactory();
			
		}
		return null;
	}

	@Override
	public Object selectRegister(int id) {
		try {
			this.startEntityManagerFactory();
			this.usuario = this.getEm().createNamedQuery("Usuario.findOne", Usuario.class).
					setParameter("param", id).getSingleResult();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.stopEntityManagerFactory();
			return this.usuario;
		}

	}

	@Override
	public void update(Object o) {
		if (o instanceof Usuario)
		{
			try 
			{
				this.startEntityManagerFactory();

				this.getEm().getTransaction().begin();
				this.getEm().merge(o);
				this.getEm().getTransaction().commit();

				this.stopEntityManagerFactory();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else 
			System.out.print("Trying to use an invalid object, error.");
				
	}

	@Override
	public void delete(Object o) {
		if (o instanceof Usuario)
		{
			try {
				this.startEntityManagerFactory();

				this.getEm().getTransaction().begin();
				this.getEm().remove(this.getEm().contains(o) ? o : this.getEm().merge(o));
				this.getEm().getTransaction().commit();

				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.stopEntityManagerFactory();
			}
		} else 
			System.out.print("Trying to use an invalid object, error.");
			
	}

	@Override
	public void insert(Object o) {
		if (o instanceof Usuario)
		{
			try 
			{
				this.startEntityManagerFactory();
				
				this.getEm().getTransaction().begin();
				this.getEm().persist(o);
				this.getEm().getTransaction().commit();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.stopEntityManagerFactory();
			}
		} else 
			System.out.print("Trying to use an invalid object, error.");
				
	}

	

}
