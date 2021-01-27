package com.kr.caption.designmode.jiketime.jike54Chapter.example2.v2;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-26
 * @Description:
 */
public class Editor {

    private List<Character> chars = new ArrayList<>();

    public void appendCharacter(char c, Font font, int size, int colorRGB) {
        Character character = new Character(c, CharacterStyleFactory.getStyle(font, size, colorRGB));
        chars.add(character);
    }
}
