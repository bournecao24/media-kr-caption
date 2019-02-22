package com.kr.caption.normal.cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CookieGenerator {
	public void addCookie(HttpServletResponse response, String cookieValue);
	
	public void removeCookie(HttpServletResponse response);
	
	public String getCookieValue(HttpServletRequest request);
}