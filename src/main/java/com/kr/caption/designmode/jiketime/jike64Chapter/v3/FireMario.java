package com.kr.caption.designmode.jiketime.jike64Chapter.v3;

import com.kr.caption.designmode.jiketime.jike64Chapter.State;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-29
 * @Description:
 */
public class FireMario implements IMario {

    private MarioStateMachine stateMachine;

    public FireMario(MarioStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public State getName() {
        return null;
    }

    @Override
    public void obtainMushRoom() {

    }

    @Override
    public void obtainCape() {

    }

    @Override
    public void obtainFireFlower() {

    }

    @Override
    public void meetMonster() {

    }
}
