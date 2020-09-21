package com.zy.filter;

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
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/userInfo","/userList","/admin.jsp","/view/flats/*"})
public class AuthFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("拦截了");
//		// 将父接口强转为子接口
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
//		StringBuffer URL = req.getRequestURL();
//		String URI = req.getRequestURI();
//		System.out.println("拦截的请求路径 : "+URL);
//		System.out.println("拦截的请求资源标识符 : "+URI);
//		if( URI.indexOf("index") != -1 || URI.indexOf("login") != -1) {
//			chain.doFilter(request, response);
//		}
		/*
		 * 判断拦截到的请求是否已经登录
		 * --> 获得请求中的session,判断是否有登录时的数据即可
		 */
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("user");
		if(obj != null) {
			// 登录,放行
			chain.doFilter(request, response);
		}else {
			// 未登录,重新登录
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}
	}


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
