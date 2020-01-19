package com.kr.caption.fornow.builderpattern;

import java.util.Map;

public abstract class AbstractKrRequest implements KrRequest {
	private KrRequestBuilder builder;
	
	public AbstractKrRequest(KrRequestBuilder builder) {
		this.builder = builder;
	}
	
	@Override
	public String getScheme() {
		return builder.getScheme();
	}

	@Override
	public String getHost() {
		return builder.getHost();
	}

	@Override
	public int getPort() {
		return builder.getPort();
	}
	
	@Override
	public String getPath() {
		return builder.getPath();
	}
	
	@Override
	public KrRequestMethod getMethod() {
		return builder.getMethod();
	}

	@Override
	public Map<String, String> getHeaders() {
		return builder.getHeaders();
	}
	
	@Override
	public Map<String, String> getQueryParameter() {
		return builder.getQueryParameter();
	}

	@Override
	public KrRequestBody getBodyType() {
		return builder.getBodyType();
	}

	@Override
	public Object getBody() {
		return builder.getBody();
	}
	
	@Override
	public int getConnectTimeout() {
		return builder.getConnectTimeout();
	}
	
	@Override
	public int getReadTimeout() {
		return builder.getReadTimeout();
	}
	
	@Override
	public KrSslSocketFactory getKrSslSocketFactory() {
		return builder.getKrSslSocketFactory();
	}
}