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

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			
			User u=UserDao.login(email, password);
			HttpSession session=req.getSession();
			if(u!=null) {
				Message msg=new Message("Login successfull...","alert-success");
				session.setAttribute("msg", msg);
				session.setAttribute("userobj", u);
				res.sendRedirect("index.jsp");
			}else {
				Message msg=new Message("Invalid email or password...","alert-danger");
				session.setAttribute("msg", msg);
				res.sendRedirect("login.jsp");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
