package book.finter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截所有  但登录页面除外 需要在代码中添加判断语句
@WebFilter("/*")
public class adminFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//排除登录页面
		String url = req.getRequestURI();
		if(url.endsWith("login") || url.endsWith("login.jsp") ||url.contains("/bower_components/") || url.endsWith("/vcode.png")) {
			chain.doFilter(request, response);
			return;
		}
		
		//权限拦截
		if(req.getSession().getAttribute("loginSuccess") == null || !req.getSession().getAttribute("loginSuccess").equals("1"))
		{
			resp.sendRedirect("login.jsp");
			return;
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
