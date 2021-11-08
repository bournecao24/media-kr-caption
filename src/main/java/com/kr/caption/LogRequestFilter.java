package com.kr.caption;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import javax.servlet.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: caozhenlong
 * @Date: 11/8/21
 * @Description:
 */
@Slf4j
public class LogRequestFilter implements Filter {


    public static final String version = new SimpleDateFormat("yyyyMMddHH24M").format(new Date());
    public static final String TRACE_ID = "traceId";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        MDC.put(TRACE_ID, UUID.randomUUID().toString().replace("-", ""));

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        }finally {
            MDC.remove(TRACE_ID);
        }

    }

    @Override
    public void destroy() {

    }
}
