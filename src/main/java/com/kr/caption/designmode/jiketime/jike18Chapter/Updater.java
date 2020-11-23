package com.kr.caption.designmode.jiketime.jike18Chapter;

/**
 * 新建一个 updater 接口，由需要热更新的类来实现它，在它们各自的类中实现 update 方法，修改它们的配置
 */
public interface Updater {

    void update();
}
