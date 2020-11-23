package com.kr.caption.designmode.jiketime.jike18Chapter;

import java.util.Map;


/**
 * 新的监控功能需求：不想通过命令行的方式来查看配置信息，在浏览器中输入这个地址，就可以显示出系统的配置信息，但是只想暴露 MySQL 和 Redis 的配置信息，不想暴露 Kafka 的配置信息。
 *
 * 按照上面的思路，这次再设计一个接口，让需要暴露信息的 Config 类实现这个类
 */
public interface Viewer {
    String outputInPlainText();
    Map<String, String> output();
}
