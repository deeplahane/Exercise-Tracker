package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.db.FactoryProvider;
import com.entities.Exercise;
import com.entities.User;

public class ExerciseDao {
	private static SessionFactory f = null;
	private static Session s = null;
	private static Transaction tx = null;

	public ExerciseDao(SessionFactory factory) {
		super();
		this.f = factory;
	}

	public static boolean saveExercise(Exercise ex) {
		boolean f = false;
		try {
			s = (Session) FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();

			s.save(ex);
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

	public static Exercise getExercise(int id) {
		Exercise ex = null;

		try {

			s = (Session) FactoryProvider.getFactory().openSession();
			s.beginTransaction();

			Query q = s.createQuery("from Exercise where id=:id");
			q.setParameter("id", id);

			ex = (Exercise) q.uniqueResult();

			s.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ex;
	}

	public static int updateExercise(Exercise ex) {
		int res=0;
		try {
			s = (Session) FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();

			Query q = s.createQuery(
					"update Exercise set exercise=:exe, note=:not, sets=:sets, weight=:wei, reps=:rep, status=:sta where id=:id ");
			q.setParameter("exe", ex.getExercise());
			q.setParameter("not", ex.getNote());
			q.setParameter("sets", ex.getSets());
			q.setParameter("wei", ex.getWeight());
			q.setParameter("rep", ex.getReps());
			q.setParameter("sta", ex.getStatus());
			q.setParameter("id", ex.getId());
			res=q.executeUpdate();
			
			tx.commit();
			s.close();
		} catch (Exception e) {
			if (tx != null) {
				res=0;
				e.printStackTrace();
			}
		}
		return res;
	}

}
