package book.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import book.dao.impl.BookDaoJdbcImpl;


@WebServlet("/bookAdd")
@MultipartConfig
public class bookAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public bookAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 解决乱码问题
		request.setCharacterEncoding("utf-8");
		// 0 解决上传
		Part part = request.getPart("photo");
		String fileName = part.getHeader("Content-Disposition").split(";")[2].split("=")[1].replace("\"", "");
		// 解决IE下错误问题
		fileName = fileName.lastIndexOf("\\") == -1 ? fileName : fileName.substring(fileName.lastIndexOf("\\") + 1);

		// 存在hibernate.cfg.xml这种⽂件名
		String ext = fileName.substring(fileName.lastIndexOf('.') + 1);
		String newFileName = UUID.randomUUID().toString() + "." + ext;
		part.write(request.getServletContext().getRealPath("upload/" + newFileName));

		String name = request.getParameter("name");
		String bookdesc = request.getParameter("desc");
		String author = request.getParameter("author");
		String bprice = request.getParameter("price");
		double price = Double.parseDouble(bprice);
		String strTid = request.getParameter("tid");
		int tid = Integer.parseInt(strTid);
		String strPubDate = request.getParameter("date");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date pubDate = null;
		try {
			pubDate = sdf.parse(strPubDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		
		BookDaoJdbcImpl book = new BookDaoJdbcImpl();
		int rs = book.save(name, bookdesc, price, author, tid, newFileName, pubDate);
		boolean bl = false;
		
		if(rs>0)
			bl = true;

		if (bl) {
			response.sendRedirect("main.jsp");
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
