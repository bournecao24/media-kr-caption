package com.kr.caption.designmode.jiketime.jike54Chapter.v2;

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

    private ChessPieceUnit chessPieceUnit;
    private int positionX;
    private int positionY;

    public ChessPiece(ChessPieceUnit chessPieceUnit, int positionX, int positionY) {
        this.chessPieceUnit = chessPieceUnit;
        this.positionX = positionX;
        this.positionY = positionY;
    }

}
