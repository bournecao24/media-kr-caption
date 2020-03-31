package com.kr.caption.designmode.jiketime.jike41Chapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * 所有的日志都写到同一个文件中，在 UserController 和 OrderController 中，我们分别创建两个 Logger 对象。在 Web 容器的 Servlet 多线程环境下，
 * 如果两个 Servlet 线程同时 分别执行 login() 和 create() 两个函数，并且同时写日志到 log.txt 文件中，那就有可能存 在日志信息互相覆盖的情况
 */
public class LoggerV1 {

    private FileWriter writer;

    public LoggerV1() {
        File file = new File("/Users/wangzheng/log.txt");
        try {
            writer = new FileWriter(file, true); //true表示追加写入
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String message) throws IOException {
        writer.write(message);
    }
}
