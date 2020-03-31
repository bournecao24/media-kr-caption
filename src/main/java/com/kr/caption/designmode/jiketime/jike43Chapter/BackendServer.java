package com.kr.caption.designmode.jiketime.jike43Chapter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * “多例”指的就是，一个类可以创建 多个对象，但是个数是有限制的，比如只能创建 3 个对象。
 */
public class BackendServer {
    private long serverNo;
    private String serverAddress;
    private static final int SERVER_COUNT = 3;
    private static final Map<Long, BackendServer> serverInstances = new HashMap<>();

    private BackendServer(long serverNo, String serverAddress) {
        this.serverNo = serverNo;
        this.serverAddress = serverAddress;
    }

    static {
        serverInstances.put(1L, new BackendServer(1L, "192.134.22.138:8080"));
        serverInstances.put(2L, new BackendServer(2L, "192.134.22.139:8080"));
        serverInstances.put(3L, new BackendServer(3L, "192.134.22.140:8080"));
    }

    public BackendServer getInstance(long serverNo) {
        return serverInstances.get(serverNo);
    }

    public BackendServer getRandomInstance() {
        Random r = new Random();
        int no = r.nextInt(SERVER_COUNT) + 1;
        return serverInstances.get(no);
    }
}
