package book.ex01;

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
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean ts = false;
		try {
			conn = DsUtil.getConn();
			String sql = "select * from user where username = ? and password = ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, pwd);
			rs = stmt.executeQuery();
			if(rs.next()) {
				ts = true;
			}
		} catch (SQLException e) {
			
		}finally {
			DsUtil.free(rs, stmt, conn);
		}
		
		if(ts) {
			response.sendRedirect("main.jsp");
		}else {
			request.setAttribute("name", name);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
