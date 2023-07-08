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

public class UpdateExerciseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
try {
			int id=Integer.parseInt(req.getParameter("id"));
			String exercise=req.getParameter("exercise");
			String note=req.getParameter("note");
			int sets=Integer.parseInt(req.getParameter("sets"));
			int weight=Integer.parseInt(req.getParameter("weight"));
			int reps=Integer.parseInt(req.getParameter("reps"));
			String status=req.getParameter("status");
			

			Exercise ex=new Exercise(id,exercise,sets,weight,reps,status,note);
			
			int f=ExerciseDao.updateExercise(ex);
			
			HttpSession session=req.getSession();
			if(f==1) {
				Message msg=new Message("Exercise updated successfully...","alert-success");
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
