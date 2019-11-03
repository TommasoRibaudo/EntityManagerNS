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
			return query.getResultList();
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			this.stopEntityManagerFactory();
			
		}
		return null;
	}

	
	@Override
	public Object selectRegister(int id) 
	{
		try {
			this.startEntityManagerFactory();
			this.destinatario = this.getEm().createNamedQuery("Destinatario.findOne", Destinatario.class).
					setParameter("param", id).getSingleResult();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.stopEntityManagerFactory();
			return this.destinatario;
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
		} else 
			System.out.print("Trying to use an invalid object, error.");
		
	}

	@Override
	public void delete(Object o) 
	{
		if (o instanceof Destinatario)
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
		} else 
			System.out.print("Trying to use an invalid object, error.");
		
	}

}
