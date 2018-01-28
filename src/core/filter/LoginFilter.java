package core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import core.permission.PermissionCheck;
import nsfw.user.entity.User;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest=(HttpServletRequest)request;
		HttpServletResponse httpServletResponse=(HttpServletResponse)response;
		User user=(User) httpServletRequest.getSession().getAttribute("user");
		String uri = httpServletRequest.getRequestURI();
		if(uri.contains("sys/login_")){
			chain.doFilter(request, response);
		}else{
			if(user!=null){
				WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(httpServletRequest.getSession().getServletContext());
				PermissionCheck check=(PermissionCheck) applicationContext.getBean("permissionCheck");
				if(check.isAccessible(user, uri)){
				chain.doFilter(request, response);
				}else{
					httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/sys/login_noPermissionUI.action");
				}
			}else{
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/sys/login_toLoginUI.action");
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
