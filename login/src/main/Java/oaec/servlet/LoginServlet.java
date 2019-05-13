package oaec.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import oaec.dao.LoginRegisterInfo;
import oaec.dao.UserDao;
import oaec.entity.User;

@WebServlet("/userlogin")
public class LoginServlet extends HttpServlet {

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
		User user = userDao.findByUsername(username);
		if(user==null){
			System.out.println("登录失败！没有此用户！");
		}else{
			if(user.getPassword().equals(password)){
				System.out.println("登录成功！");
			}else{
				System.out.println("登录失败！密码不正确！");
			}
		}
	}

}
