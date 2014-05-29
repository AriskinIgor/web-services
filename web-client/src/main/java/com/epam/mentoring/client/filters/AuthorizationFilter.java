package com.epam.mentoring.client.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.mentoring.client.model.AuthorizationCredential;
import com.epam.mentoring.client.services.AuthorizationService;
import com.epam.mentoring.client.services.AuthorizationService_Service;

@WebFilter(displayName = "AuthorizationFilter", value = "/*")
public class AuthorizationFilter implements Filter {

	private static final String AUTH_COOKIE_NAME = "authUser";

	private static final int AUTH_COOKIE_MAX_AGE = 60;

	private static final String LOGIN_PAGE = "/index.jsp";

	private static final String MAIN_PAGE = "/web-client/protected/main.jsp";

	private static final String ATTR_NAME_ERROR = "error";

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		boolean isAuth = findCookieByName(req);
		req.setAttribute(ATTR_NAME_ERROR, "");
		if (isAuth) {
			System.out.println("!!!isAuth");
			chain.doFilter(request, response);
		} else {
			AuthorizationCredential credential = new AuthorizationCredential();
			String error = validateCredential(req);
			System.out.println("error valid = " + error);
			if (error != null) {
				forwardToLoginPage(error, req, resp);
				return;
			}
			credential.setLogin(req.getParameter("login"));
			credential.setPassword(req.getParameter("password"));
			AuthorizationService_Service authService = new AuthorizationService_Service();
			AuthorizationService port = authService
					.getAuthorizationServicePort();
			boolean authResult = port.authorization(credential);
			System.out.println("AuthResult: " + authResult);
			if (!authResult) {
				forwardToLoginPage("Неверный логин и пароль!", req, resp);
				return;
			}
			saveCookie(resp);
			resp.sendRedirect(MAIN_PAGE);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void destroy() {
	}

	private void forwardToLoginPage(String error, HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute(ATTR_NAME_ERROR, error);
		req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
	}

	private void saveCookie(HttpServletResponse resp) {
		Cookie cookie = new Cookie(AUTH_COOKIE_NAME, AUTH_COOKIE_NAME);
		cookie.setMaxAge(AUTH_COOKIE_MAX_AGE);
		resp.addCookie(cookie);
	}

	private String validateCredential(HttpServletRequest req) {
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		if ((login == null || login.isEmpty())
				&& (password == null || password.isEmpty())) {
			return "Введите логин и пароль!";
		} else if (login == null || login.isEmpty()) {
			return "Введите логин!";
		} else if (password == null || password.isEmpty()) {
			return "Введите пароль!";
		}
		return null;
	}

	private boolean findCookieByName(HttpServletRequest req) {
		if (req.getCookies() == null) {
			return false;
		}
		for (Cookie cookie : req.getCookies()) {
			if (AUTH_COOKIE_NAME.equals(cookie.getName())) {
				return true;
			}
		}
		return false;
	}
}
