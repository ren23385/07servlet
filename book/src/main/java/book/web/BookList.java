package book.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.biz.BookBiz;
import book.biz.impl.BookBizImpl;
import book.util.PageConstant;
import book.vo.BookVo;

@WebServlet("/bookList")
public class BookList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1
		String strPageNo = request.getParameter("pageNo");
		int pageNo;
		try {
			pageNo = Integer.parseInt(strPageNo);
		} catch (NumberFormatException e) {
			pageNo = 1;// 默认看第一页
		}
		// 2
		BookBiz bookBiz = new BookBizImpl();
		List<BookVo> ls = bookBiz.findAllBooks(pageNo);
		int total = bookBiz.findTotal();
		// 3
		if (total % PageConstant.PAGE_SIZE == 0) {
			request.setAttribute("totalPage", total / PageConstant.PAGE_SIZE);
		} else {
			request.setAttribute("totalPage", total / PageConstant.PAGE_SIZE + 1);
		}
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("ls", ls);
		request.getRequestDispatcher("bookList.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
