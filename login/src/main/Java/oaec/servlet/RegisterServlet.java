package oaec.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oaec.dao.UserDao;
import oaec.entity.User;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	private UserDao userDao;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao userDao = new UserDao();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
        int id = userDao.add(user);

        if(id>0){
            System.out.println("注册成功！");
        }else{
            System.out.println("注册失败！");
        }
	}

}
