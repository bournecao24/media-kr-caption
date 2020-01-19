package com.kr.caption.fornow.builderpattern;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public interface KrSslSocketFactory {
	public static final String TLS   = "TLS";
    public static final String SSL   = "SSL";
    public static final String SSLV2 = "SSLv2";
    
	public X509TrustManager getTrustManager();
	
	public KeyManager[] getKeyManager();
	
	public SSLSocketFactory getSSLSocketFactory();
}