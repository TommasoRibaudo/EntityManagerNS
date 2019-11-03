package com.entityManager;

import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import com.entity.Destinatario;  
/**/
@SuppressWarnings("finally")
public class ManagerDestinatario extends Manager {

	private TypedQuery<Destinatario> query;
	private Destinatario destinatario;

	@Override
	public List<Destinatario> selectAll() 
	{
		try {
			this.startEntityManagerFactory();
			this.query = this.getEm().createNamedQuery("Destinatario.findAll", Destinatario.class);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			this.stopEntityManagerFactory();
			return query.getResultList();
		}
	}

	
	@Override
	public Object selectRegister(int id) 
	{
		try {
			this.startEntityManagerFactory();
			this.destinatario = this.getEm().createNamedQuery("Destinatario.findOne", Destinatario.class).
					setParameter("param", id).getSingleResult();
			
			return this.destinatario;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.stopEntityManagerFactory();
			return destinatario;
		}

	}

	@Override
	public void update(Object o) 
	{
		if (o instanceof Destinatario)
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
		}
	}

	@Override
	public void delete(Object o) 
	{
		if (o instanceof Destinatario)
		{
			try {
				this.startEntityManagerFactory();

				this.getEm().getTransaction().begin();
				this.getEm().remove(o);
				this.getEm().getTransaction().commit();

				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.stopEntityManagerFactory();
			}
		}
	}

	@Override
	public void insert(Object o) 
	{
		if (o instanceof Destinatario)
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
		}
	}

}