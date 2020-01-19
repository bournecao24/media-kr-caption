package com.kr.caption.fornow.builderpattern;

import java.util.HashMap;
import java.util.Map;

public abstract class KrRequestBuilder {
	/**基本信息**/
	private String scheme;
	private String host;
	private int port;
	private String path;
	private KrRequest.KrRequestMethod method;
	/**参数信息**/
	private Map<String, String> headers;
	private Map<String, String> queryParameter;
	private KrRequest.KrRequestBody bodyType;
	private Object body;
	/**扩展信息**/

	private int connectTimeout;
	private int readTimeout;
	private KrSslSocketFactory krSslSocketFactory;
	
	public KrRequestBuilder() {
		this.scheme = "http";
		this.host = "localhost";
		this.port = -1;
		this.path = "/";
		this.method = KrRequest.KrRequestMethod.GET;
		this.connectTimeout = 3000;
		this.readTimeout = 2000;
		this.body = null;
		this.bodyType = KrRequest.KrRequestBody.FORM;
		this.headers = null;
		this.queryParameter = null;
		this.krSslSocketFactory = null;
	}
	
	public KrRequestBuilder(KrRequest request) {
		this.scheme = request.getScheme();
		this.host = request.getHost();
		this.port = request.getPort();
		this.path = request.getPath();
		this.method = request.getMethod();
		this.connectTimeout = request.getConnectTimeout();
		this.readTimeout = request.getReadTimeout();
		this.body = request.getBody();
		this.bodyType = request.getBodyType();
		this.headers = request.getHeaders();
		this.queryParameter = request.getQueryParameter();
		this.krSslSocketFactory = request.getKrSslSocketFactory();
	}
	
	
	/**设置基本信息**/
	public KrRequestBuilder setScheme(String scheme) {
		this.scheme = scheme;
		return this;
	}
	
	public KrRequestBuilder setHost(String host) {
		this.host = host;
		return this;
	}
	
	public KrRequestBuilder setPort(int port) {
		this.port = port;
		return this;
	}
	
	public KrRequestBuilder setPath(String path) {
		this.path = path;
		return this;
	}
	
	public KrRequestBuilder get() {
		this.method = KrRequest.KrRequestMethod.GET;
		return this;
	}
	
	public KrRequestBuilder post() {
		this.method = KrRequest.KrRequestMethod.POST;
		return this;
	}
	
	public KrRequestBuilder put() {
		this.method = KrRequest.KrRequestMethod.PUT;
		return this;
	}
	
	public KrRequestBuilder delete() {
		this.method = KrRequest.KrRequestMethod.DELET;
		return this;
	}
	
	public KrRequestBuilder setHttpMethod(String httpMethod) {
		if (httpMethod.toUpperCase().equals(KrRequest.KrRequestMethod.GET.name())) {
			this.method = KrRequest.KrRequestMethod.GET;
		} else if (httpMethod.toUpperCase().equals(KrRequest.KrRequestMethod.POST.name())) {
			this.method = KrRequest.KrRequestMethod.POST;
		} else if (httpMethod.toUpperCase().equals(KrRequest.KrRequestMethod.PUT.name())) {
			this.method = KrRequest.KrRequestMethod.PUT;
		} else if (httpMethod.toUpperCase().equals(KrRequest.KrRequestMethod.DELET.name())) {
			this.method = KrRequest.KrRequestMethod.DELET;
		}
		return this;
	}
	
	/**设置扩展信息**/
	public KrRequestBuilder setConnectTimeout(int milliseconds) {
		this.connectTimeout = milliseconds;
		return this;
	}
	
	public KrRequestBuilder setReadTimeout(int milliseconds) {
		this.readTimeout = milliseconds;
		return this;
	}
	
	/**设置参数信息**/
	public KrRequestBuilder setJsonBody(String json) {
		this.bodyType = KrRequest.KrRequestBody.JSON;
		this.body = json;
		return this;
	}
	
	public KrRequestBuilder addHeader(String name, String value) {
		if (this.headers == null) {
			this.headers = new HashMap<String, String>();
		}
		this.headers.put(name, value);
		return this;
	}
	
	public KrRequestBuilder setHeader(Map<String, String> headers) {
		this.headers = headers;
		return this;
	}
	
	public KrRequestBuilder addQueryParameter(String name, String value) {
		if (this.queryParameter == null) {
			this.queryParameter = new HashMap<String, String>();
		}
		this.queryParameter.put(name, value);
		return this;
	}
	
	public KrRequestBuilder setQueryParameter(Map<String, String> queryParameter) {
		this.queryParameter = queryParameter;
		return this;
	}

	@SuppressWarnings("unchecked")
	public KrRequestBuilder addFormBody(String name, String value) {
		if (this.body == null) {
			this.body = new HashMap<String, String>();
			this.bodyType = KrRequest.KrRequestBody.FORM;
		}
		((Map<String, String>)this.body).put(name, value);
		return this;
	}
	
	public KrRequestBuilder setFormBody(Map<String, String> formBodyMap) {
		this.body = formBodyMap;
		this.bodyType = KrRequest.KrRequestBody.FORM;
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public KrRequestBuilder addMutilpartBody(String name, Object value) {
		if (this.body == null) {
			this.body = new HashMap<String, Object>();
			this.bodyType = KrRequest.KrRequestBody.MULTIPART;
		}
		((Map<String, Object>)this.body).put(name, value);
		return this;
	}
	
	public KrRequestBuilder setMutilpartBody(Map<String, Object> mutilpartBodyMap) {
		this.body = mutilpartBodyMap;
		this.bodyType = KrRequest.KrRequestBody.MULTIPART;
		return this;
	}
	
	public KrRequestBuilder setCustomBody(KrRequestCustomBody body) {
		this.body = body;
		this.bodyType = KrRequest.KrRequestBody.CUSTOM;
		return this;
	}
	
	public void setKrSslSocketFactory(KrSslSocketFactory krSslSocketFactory) {
		this.krSslSocketFactory = krSslSocketFactory;
	}
	
	
	
	
	
	/**只读信息**/
	public String getScheme() {
		return scheme;
	}

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getPath() {
		return path;
	}

	public KrRequest.KrRequestMethod getMethod() {
		return method;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public Map<String, String> getQueryParameter() {
		return queryParameter;
	}

	public KrRequest.KrRequestBody getBodyType() {
		return bodyType;
	}

	public Object getBody() {
		return body;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public int getReadTimeout() {
		return readTimeout;
	}
	
	public KrSslSocketFactory getKrSslSocketFactory() {
		return krSslSocketFactory;
	}
	
	public abstract <T extends KrRequest> T build();
}