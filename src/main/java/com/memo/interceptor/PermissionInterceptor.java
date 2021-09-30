package com.memo.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class PermissionInterceptor implements HandlerInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
		// 세션을 가져온다
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		// url path을 가져온다
		String uri = request.getRequestURI();
		// 만약 로그인이 되어 있으면 + /user => post쪽으로 보낸다.
		if (userId != null && uri.startsWith("/user")) {
			response.sendRedirect("/post/post_list_view");
			return false;
		} else if (userId == null && uri.startsWith("/post")) {
			response.sendRedirect("/user/sign_in_view");
			return false;
		}
		// 만약 로그인이 안되어있으면 + /post => user쪽으로 보낸다.
		
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, 
			    HttpServletResponse response, 
			    Object handler, 
			    ModelAndView modelAndView) {
		
	}
	@Override
	public void afterCompletion(
	        HttpServletRequest request, 
	        HttpServletResponse response, 
	        Object handler,
	        Exception ex) throws Exception {
	}
	}
		