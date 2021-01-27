package com.kr.caption.designmode.jiketime.jike54Chapter.v2;

import lombok.Data;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-25
 * @Description:
 */
@Data
public class ChessPieceUnit {

    private int id;
    private String text;
    private Color color;

    public ChessPieceUnit(int id, String text, Color color) {
    }

    public enum Color {
        BLACK, WHITE
    }

}
