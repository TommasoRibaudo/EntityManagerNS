package com.entityServices;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.entities.Destinatario;
import com.entities.Usuario;

@SuppressWarnings("finally")
public class ServiceUsuario extends Service {
	private TypedQuery<Usuario> query;
	private Usuario usuario;
	private static String sql;
	private ResultSet rs = null;
	private PreparedStatement pstm = null;

	@Override
	public List<Usuario> selectAll() {
		try {

			this.query = this.getEm().createNamedQuery("Usuario.findAll", Usuario.class);
			return query.getResultList();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object selectRegister(int id) {
		try {

			this.usuario = this.getEm().createNamedQuery("Usuario.findOne", Usuario.class).setParameter("param", id)
					.getSingleResult();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return this.usuario;
		}

	}

	@Override
	public void update(Object o) {
		if (o instanceof Usuario) {
			try {

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
	public void delete(Object o) {
		if (o instanceof Usuario) {
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
	public void insert(Object o) {
		if (o instanceof Usuario) {
			try {

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

//  METODO PARA VERIFICAR SI LA CUENTA EXISTE
	public Usuario verify(String uid) {
		Usuario user = null;
		try {

			Session session = this.getEm().unwrap(Session.class);
			Criteria criteria = session.createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("authId", uid));
			user = (Usuario) criteria.uniqueResult();

		} catch (NonUniqueResultException e) {
			e.printStackTrace();
		}

		if (user == null) {
			System.out.println("user not register on our sysytem!");
		} else {
			System.out.println("Welcome " + user.getName());
		}
		return user;
	}

	public void signSocial(Usuario user) {

		try {
			Usuario verifyUser = this.verify(user.getAuthId());
			if (verifyUser == null || "".equals(user.getAuthId())) {
//              SI EL USUARIO NO EXISTE SE INSERTA EN LA BASE
				this.insert(user);
			} else {
//              SI EXISTE EL USUARIO, LO ACTUALIZA
				this.update(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
