package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExerciseDao;
import com.entities.Exercise;
import com.entities.Message;
import com.entities.User;

public class AddExerciseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			
			String exercise=req.getParameter("exercise");
			String note=req.getParameter("note");
			int sets=Integer.parseInt(req.getParameter("sets"));
			int weight=Integer.parseInt(req.getParameter("weight"));
			int reps=Integer.parseInt(req.getParameter("reps"));
			String status=req.getParameter("status");
			
			HttpSession session=req.getSession();
			User u=(User) session.getAttribute("userobj");
			Exercise ex=new Exercise(exercise,sets,weight,reps,status,note,u);
			
			boolean f=ExerciseDao.saveExercise(ex);
			
			if(f) {
				Message msg=new Message("Exercise added successfully...","alert-success");
				session.setAttribute("msg", msg);
				session.setAttribute("userobj", u);
				res.sendRedirect("add_exercise.jsp");
			}else {
				Message msg=new Message("Oops! Something went wrong...","alert-danger");
				session.setAttribute("msg", msg);
				res.sendRedirect("add_excercise.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
