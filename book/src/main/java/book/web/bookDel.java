package book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.biz.BookBiz;
import book.biz.impl.BookBizImpl;

@WebServlet("/bookDel")
public class bookDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public bookDel() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String srid = request.getParameter("id");
		int id = Integer.parseInt(srid);
		
		BookBiz bookbiz = new BookBizImpl();
		boolean ret = bookbiz.bookdel(id);
		
		if(!ret) {
			request.setAttribute("msg", "删除失败");
		}
		request.getRequestDispatcher("bookList").forward(request, response);
		
	}

	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
