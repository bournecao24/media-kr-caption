package com.kr.caption.designmode.jiketime.jike54Chapter;

import java.util.HashMap;
import java.util.Map;

/**
 * 棋局
 *
 * @Author: caozhenlong
 * @Date: 2021-01-25
 * @Description:
 */
public class ChessBoard {

    private Map<Integer, ChessPiece> chessPieces = new HashMap<>();

    public ChessBoard() {
        init();
    }

    private void init() {
        chessPieces.put(1, new ChessPiece(1, "車", ChessPiece.Color.BLACK, 0, 0));
        chessPieces.put(2, new ChessPiece(2, "馬", ChessPiece.Color.BLACK, 0, 1));
        //...省略摆放其他棋子的代码... 需要把所有棋子都放进去
    }

    public void move(int chessPieceId, int toPositionX, int toPositionY) {
        //...省略...
    }

}
