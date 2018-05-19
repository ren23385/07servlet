package book.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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

import org.apache.commons.beanutils.BeanUtils;

import book.biz.BookBiz;
import book.biz.impl.*;
import book.util.MyBeanUtils;
import book.vo.BookVo;


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
		
		BookVo bookvo = new BookVo();
		/*try {
			BeanUtils.populate(bookvo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		MyBeanUtils.populate(bookvo, request.getParameterMap(),"yyyy-mm-dd");
		bookvo.setPhoto(newFileName);
		
		BookBiz bookBiz = new BookBizImpl();
		int rs = bookBiz.saveBook(bookvo);
		response.setContentType("text/html;charset=utf-8");
		if (rs>0) {
			response.sendRedirect("main.jsp");
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
