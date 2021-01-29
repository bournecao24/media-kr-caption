package com.kr.caption.designmode.jiketime.jike64Chapter.v3;

import com.kr.caption.designmode.jiketime.jike64Chapter.State;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-29
 * @Description:
 */
public interface IMario { //所有状态类的接口
    State getName(); //以下是定义的事件

    void obtainMushRoom();

    void obtainCape();

    void obtainFireFlower();

    void meetMonster();
}
