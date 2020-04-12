package com.kr.caption.designmode.jiketime.jike64Chapter;

/**
 * 最简单直接的实现方式是，参照状态转移图，将每一个状态转移，原模原样地直译成代码。这样编写的代码会包含大量的 if-else 或 switch-case 分支判断逻辑，甚至是嵌套的分支判断逻辑.
 *
 * 这种实现方式极易漏写或者错写某个状态转移。除此之外，代码中充斥着大量的 if- else 或者 switch-case 分支判断逻辑，可读性和可维护性都很差。
 */
public class MarioStateMachine {

    private int score;
    private State currentState;

    public MarioStateMachine(int score, State currentState) {
        this.score = 0;
        this.currentState = State.SMALL;
    }


    public void obtainMushRoom() {
        if (currentState.equals(State.SMALL)) {
            this.currentState = State.SUPER;
            this.score += 100;
        }
    }

    public void obtainCape() {
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER))
            this.currentState = State.CAPE;
        this.score += 200;

    }

    public void obtainFireFlower() {
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER))
            this.currentState = State.FIRE;
        this.score += 300;
    }

    public void meetMonster() {
        if (currentState.equals(State.SUPER)) {
            this.currentState = State.SMALL;
            this.score -= 100;
            return;
        }

        if (currentState.equals(State.CAPE)) {
            this.currentState = State.SMALL;
            this.score -= 200;
            return;
        }
        if (currentState.equals(State.FIRE)) {
            this.currentState = State.SMALL;
            this.score -= 300;
            return;
        }
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState;
    }
}
