package com.kr.caption.designmode.jiketime.jike48Chapter.dynamicproxy;


import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RequestInfo;
import com.kr.caption.designmode.jiketime.jike25Chapter.v4.MetricsCollector;
import com.kr.caption.designmode.jiketime.jike48Chapter.IUserController;
import com.kr.caption.designmode.jiketime.jike48Chapter.UserControllerV2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class MetricsCollectorProxy {
    private MetricsCollector metricsCollector;
    public MetricsCollectorProxy() {
        this.metricsCollector = new MetricsCollector();
    }
    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler proxyHandler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, proxyHandler);
    }

    public class DynamicProxyHandler implements InvocationHandler {
        private Object proxiedObject;
        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTimestamp = System.currentTimeMillis();
            Object result = method.invoke(proxiedObject, args);
            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;

            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
            RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTimestamp);
            metricsCollector.recordRequest(requestInfo);
            return result;
        }
    }
    public static void main(String[] args) {
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController proxy1 = (IUserController) proxy.createProxy(new UserControllerV2());

    }
}
