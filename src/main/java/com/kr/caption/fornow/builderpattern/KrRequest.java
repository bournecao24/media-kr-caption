package com.kr.caption.fornow.builderpattern;

import java.util.Map;

public interface KrRequest {
	public String getScheme();
	
	public String getHost();
	
	public int getPort();
	
	public String getPath();
	
	public KrRequestMethod getMethod();
	
	public Map<String, String> getHeaders();
	
	public Map<String, String> getQueryParameter();
	
	public KrRequestBody getBodyType();
	
	public Object getBody();
	
	public int getConnectTimeout();
	
	public int getReadTimeout();
	
	public KrSslSocketFactory getKrSslSocketFactory();
	
	public KrRequestBuilder newBuilder();
	
	public enum KrRequestMethod {
		GET,
		POST,
		PUT,
		DELET
	}
	
	public enum KrRequestBody {
		FORM,
		JSON,
		MULTIPART,
		CUSTOM
	}
}