package com.kr.caption.designmode.jiketime.jike35Chapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;


/**
 * IdGenerator 设计成了实现类而非接口，调用者直接依赖实现而非接口，违反基于接口而非实现编程的设计思想。
 * 把 IdGenerator 的 generate() 函数定义为静态函数，会影响使用该函数的代码的可测试性。
 * 同时，generate() 函数的代码实现依赖运行环境(本机名)、时间函数、随机函 数，所以 generate() 函数本身的可测试性也不好，需要做比较大的重构。
 *
 * 一方面，代码完全没有注释，生成算法比较难读懂，
 * 另一方面，代码里有很多魔法数，严重影响代码的可读性。在重构的时候，我们需要重 点提高这部分代码的可读性。
 */
public class IdGenerator {
    private static final Logger logger = LoggerFactory.getLogger(IdGenerator.class);

    protected static String generate() {
        String id = "";
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            String[] tokens = hostName.split("\\.");
            if (tokens.length > 0) {
                hostName = tokens[tokens.length - 1];
            }
            char[] randomChars = new char[8];
            int count = 0;
            Random random = new Random();
            while (count < 8) {
                int randomAscii = random.nextInt(122);
                if (randomAscii >= 48 && randomAscii <= 57) {
                    randomChars[count] = (char) ('0' + (randomAscii - 48));
                    count++;
                } else if (randomAscii >= 65 && randomAscii <= 90) {
                    randomChars[count] = (char) ('A' + (randomAscii - 65));
                    count++;
                } else if (randomAscii >= 97 && randomAscii <= 122) {
                    randomChars[count] = (char) ('a' + (randomAscii - 97));
                    count++;
                }
            }
            id = String.format("%s-%d-%s", hostName,
                    System.currentTimeMillis(), new String(randomChars));
        } catch (UnknownHostException e) {   // 异常处理不合格
            logger.warn("Failed to get the host name.", e);
        }
        return id;
    }
}
