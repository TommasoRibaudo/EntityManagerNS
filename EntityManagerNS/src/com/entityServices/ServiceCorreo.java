package com.entityServices;

import java.util.List;
import javax.persistence.TypedQuery;
import com.entities.Correo;

@SuppressWarnings("finally")
public class ServiceCorreo extends Service {
	private TypedQuery<Correo> query;
	private Correo correo;

	@Override
	public List<Correo> selectAll() 
	{
		try {
			
			this.query = this.getEm().createNamedQuery("Correo.findAll", Correo.class);
			return query.getResultList();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		return null;
	}

	
	@Override
	public Object selectRegister(int id) 
	{
		try {
			
			this.correo = this.getEm().createNamedQuery("Correo.findOne", Correo.class).
					setParameter("param", id).getSingleResult();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			return this.correo;
		}

	}

	@Override
	public void update(Object o) 
	{
		if (o instanceof Correo)
		{
			try 
			{
				

				this.getEm().getTransaction().begin();
				this.getEm().merge(o);
				this.getEm().getTransaction().commit();

				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else 
			System.out.print("Trying to use an invalid object, error.");
		
	}

	@Override
	public void delete(Object o) 
	{
		if (o instanceof Correo)
		{
			try {
				

				this.getEm().getTransaction().begin();
				this.getEm().remove(this.getEm().contains(o) ? o : this.getEm().merge(o));
				this.getEm().getTransaction().commit();

				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else 
			System.out.print("Trying to use an invalid object, error.");
	}

	@Override
	public void insert(Object o) 
	{
		if (o instanceof Correo)
		{
			try 
			{
				
				
				this.getEm().getTransaction().begin();
				this.getEm().persist(o);
				this.getEm().getTransaction().commit();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} else 
			System.out.print("Trying to use an invalid object, error.");
		
	}



}
