package com.kr.caption.designmode.jiketime.jike41Chapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * 我们将 Logger 设计成一个单例类，程序中只允许创建一个 Logger 对象，所有的线程共享使用的这一个 Logger 对象，共享一个 FileWriter 对象，
 * 而 FileWriter 本身是对象级别线 程安全的，也就避免了多线程情况下写日志会互相覆盖的问题。
 */
public class Logger {
    private FileWriter fileWriter;
    private static final Logger instance = new Logger();

    public Logger(){
        File file = new File("/Users/sdsd");
        try {
            fileWriter = new FileWriter(file, true);   // true 表示追加写入
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Logger getInstance() {
        return instance;
    }
    public void log(String message) throws IOException {
        fileWriter.write(message);
    }
}
