package com.kr.caption.designmode.jiketime.jike54Chapter;

import lombok.Data;

/**
 * 棋子
 *
 * @Author: caozhenlong
 * @Date: 2021-01-25
 * @Description:
 */

@Data
public class ChessPiece {
    private int id;
    private String text;
    private Color color;
    private int positionX;
    private int positionY;

    public enum Color {
        BLACK, WHITE
    }

    public ChessPiece(int id, String text, Color color, int positionX, int positionY) {
        this.id = id;
        this.text = text;
        this.color = color;
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
