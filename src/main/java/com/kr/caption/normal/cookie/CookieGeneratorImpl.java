package com.kr.caption.normal.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieGeneratorImpl implements CookieGenerator {
	private static final String DEFAULT_COOKIE_PATH = "/";
	private String cookieName;
	private String cookieDomain;
	private String cookiePath = DEFAULT_COOKIE_PATH;
	private Integer cookieMaxAge = -1;
	private boolean cookieSecure = false;
	private boolean cookieHttpOnly = false;

	@Override
	public void addCookie(HttpServletResponse response, String cookieValue) {
		if (cookieDomain == null) {
			throw new IllegalArgumentException("cookies domain is not null");
		}
		
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setPath(cookiePath);
		if (cookieDomain != null) {
			cookie.setDomain(cookieDomain);
		}
		if (cookieMaxAge != null) {
			cookie.setMaxAge(cookieMaxAge);
		}
		if (cookieSecure) {
			cookie.setSecure(true);
		}
		if (cookieHttpOnly) {
			cookie.setHttpOnly(true);
		}
		response.addCookie(cookie);
	}

	@Override
	public void removeCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie(cookieName, null);
		cookie.setPath(cookiePath);
		cookie.setMaxAge(0);
		cookie.setDomain(cookieDomain);
		response.addCookie(cookie);
	}

	@Override
	public String getCookieValue(HttpServletRequest request) {
		Cookie cookies[] = request.getCookies();
		if (cookies == null) {
			return null;
		}
		
		for (Cookie cookie : cookies) {
			if (cookieName.equals(cookie.getName())) {
				return cookie.getValue();
			}
		}
		
		return null;
	}

	public void setCoookieName(String coookieName) {
		this.cookieName = coookieName;
	}

	public void setCookieDomain(String cookieDomain) {
		this.cookieDomain = cookieDomain;
	}

	public void setCookiePath(String cookiePath) {
		this.cookiePath = cookiePath;
	}

	public void setCookieMaxAge(Integer cookieMaxAge) {
		this.cookieMaxAge = cookieMaxAge;
	}

	public void setCookieSecure(boolean cookieSecure) {
		this.cookieSecure = cookieSecure;
	}

	public void setCookieHttpOnly(boolean cookieHttpOnly) {
		this.cookieHttpOnly = cookieHttpOnly;
	}
}