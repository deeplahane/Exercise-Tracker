package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.db.FactoryProvider;
import com.entities.User;

public class UserDao {
	private static SessionFactory f = null;
	private static Session s = null;
	private static Transaction tx = null;

	public UserDao(SessionFactory factory) {
		super();
		this.f = factory;
	}

	public static boolean saveUser(User u) {
		boolean f = false;
		try {
			s = (Session) FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();

			s.save(u);
			tx.commit();
			f = true;
			s.close();
		} catch (Exception e) {
			if (tx != null) {
				f = false;
				e.printStackTrace();
			}
		}
		return f;
	}

	public static User login(String email, String password) {
		User u = null;

		try {
			s=(Session) FactoryProvider.getFactory().openSession();
			Query q=s.createQuery("from User where email=:ema and password=:pas");
			q.setParameter("ema", email);
			q.setParameter("pas", password);
			u=(User) q.uniqueResult();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

}
