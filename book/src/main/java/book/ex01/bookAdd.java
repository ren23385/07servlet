package book.ex01;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookAdd")
public class bookAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public bookAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String bookdesc = request.getParameter("desc");
		String author = request.getParameter("author");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean bl = false;
		
		try {
			conn = DsUtil.getConn();
			String sql = "insert into bookdetails (bookname,bookdesc,bookauthor) values (?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, bookdesc);
			stmt.setString(3, author);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				bl = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DsUtil.free(stmt, conn);
		}
		
		if(bl) {
			response.sendRedirect("main.jsp");
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
