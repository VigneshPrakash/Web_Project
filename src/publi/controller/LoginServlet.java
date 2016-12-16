package publi.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends DBServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        connect();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String next = "form.jsp";
		ResultSet result = executeQuery("select * from user where login = '" + login + "' and password = '" + password + "'");
		try {
			if(!result.isAfterLast())
				next = "correct.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(next).forward(request, response);
	}
}
