package com.kr.caption.designmode.jiketime.jike64Chapter.v4;

import com.kr.caption.designmode.jiketime.jike64Chapter.State;

/**
 *
 * 我们可以将状态类设计成单例，毕竟状态类中不包含任何成员变量。但是，当将状态类设计成单例之后，我们就无法通过构造函数来传递 MarioStateMachine 了，而状态类又要依赖 MarioStateMachine，那该如何解决这个问题呢？
 * 我们可以通过函数参数将 MarioStateMachine 传递进状态类
 *
 *
 *
 * @Author: caozhenlong
 * @Date: 2021-01-29
 * @Description:
 */
public interface IMario {
    State getName();

    void obtainMushRoom(MarioStateMachine stateMachine);

    void obtainCape(MarioStateMachine stateMachine);

    void obtainFireFlower(MarioStateMachine stateMachine);

    void meetMonster(MarioStateMachine stateMachine);
}
