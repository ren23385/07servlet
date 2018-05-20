package book.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.biz.impl.adminImpl;
import book.util.DsUtil;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String vcode = request.getParameter("vcode");
		// 
		HttpSession session = request.getSession();
		String serverVcode = (String) session.getAttribute("validateCode");
		// 
		if (!serverVcode.equalsIgnoreCase(vcode)) {
			// 
			request.setAttribute("msg", "验证码错误");
			request.setAttribute("name", name);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		//
		adminImpl adminimpl = new adminImpl();
		boolean ts = adminimpl.checkuser(name,pwd);
		
		if(ts) {
			//记录是否成功
			request.getSession().setAttribute("loginSuccess", "1");
			//
			response.sendRedirect("main.jsp");
		}else {
			request.setAttribute("msg", "用户名或密码错误");
			request.setAttribute("name", name);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
