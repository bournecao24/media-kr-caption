package com.kr.caption.designmode.jiketime.jike62Chapter.v4;

import javax.servlet.*;
import java.io.IOException;

/**
 * ApplicationFilterChain 中的 doFilter() 函数的代码实现比较有技巧，实际上是一个递归调 用。你可以用每个 Filter(比如 LogFilter)的 doFilter() 的代码实现，
 * 直接替换 ApplicationFilterChain 的第 12 行代码，一眼就能看出是递归调用了
 */
public class ApplicationFilterChain implements FilterChain {

    private int pos = 0; //当前执行到了哪个filter
    private int n; //filter的个数
    //    private ApplicationFilterConfig[] filters;
    private Servlet servlet;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {
        if (pos < n) {
//            ApplicationFilterConfig filterConfig = filters[pos++];
//            Filter filter = filterConfig.getFilter();
//            filter.doFilter(request, response, this);
        } else {
// filter都处理完毕后，执行servlet servlet.service(request, response);
        }
    }


//    public void addFilter(ApplicationFilterConfig filterConfig) {
//        for (ApplicationFilterConfig filter : filters)
//            if (filter == filterConfig) return;
//        if (n == filters.length) {//扩容
//            ApplicationFilterConfig[] newFilters = new ApplicationFilterConfig[n + INACTIVE
//            System.arraycopy(filters, 0, newFilters, 0, n);
//            filters = newFilters;
//        }
//        filters[n++] = filterConfig;
//    }

}
