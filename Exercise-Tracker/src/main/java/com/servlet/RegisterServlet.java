package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.entities.Message;
import com.entities.User;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String name=req.getParameter("name");
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			String gender=req.getParameter("gender");
			int age=Integer.parseInt(req.getParameter("age"));
			int weight=Integer.parseInt(req.getParameter("weight"));
			int height=Integer.parseInt(req.getParameter("height"));
			
			User user=new User(name,email,password,gender,age,weight,height);
			
			boolean f=UserDao.saveUser(user);
			
			HttpSession session=req.getSession();
			if(f) {
				Message msg=new Message("Congrats! Registration successfull...","alert-success");
				session.setAttribute("msg", msg);
				res.sendRedirect("login.jsp");
			}else {
				Message msg=new Message("Oops! something went wrong...","alert-danger");
				session.setAttribute("msg", msg);
				res.sendRedirect("register.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
