package book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.biz.BookBiz;
import book.biz.impl.BookBizImpl;
import book.vo.BookVo;

@WebServlet("/bookEdit")
public class BookEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public BookEdit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//权限拦截
		/*if(request.getSession().getAttribute("loginSuccess") == null || !request.getSession().getAttribute("loginSuccess").equals("1"))
		{
			response.sendRedirect("login.jsp");
			return;
		}*/
		
		
		
		String srid = request.getParameter("tid");
		int id = Integer.parseInt(srid);
		BookBiz bookbiz = new BookBizImpl();
		BookVo bookvo =  bookbiz.findById(id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
