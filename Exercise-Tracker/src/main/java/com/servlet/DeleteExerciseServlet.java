package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.db.FactoryProvider;
import com.entities.Message;

public class DeleteExerciseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			
			int id=Integer.parseInt(req.getParameter("id"));
			
			Session s=FactoryProvider.getFactory().openSession();
			Transaction tx=s.beginTransaction();
			
			Query q=s.createQuery("delete from Exercise where id=:id");
			q.setParameter("id", id);
			int v=q.executeUpdate();
			tx.commit();
			s.close();
			
			HttpSession session=req.getSession();
			if(v==1) {
				Message msg=new Message("Exercise deleted successfully...","alert-success");
				session.setAttribute("msg", msg);
				res.sendRedirect("view_workout.jsp");
			}else {
				Message msg=new Message("Oops! Something went wrong...","alert-danger");
				session.setAttribute("msg", msg);
				res.sendRedirect("view_workout.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
