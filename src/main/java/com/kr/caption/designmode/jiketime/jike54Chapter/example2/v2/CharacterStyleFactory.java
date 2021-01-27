package com.kr.caption.designmode.jiketime.jike54Chapter.example2.v2;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-26
 * @Description:
 */
public class CharacterStyleFactory {

    private static final List<CharacterStyle> styles = new ArrayList<>();

    public static CharacterStyle getStyle(Font font, int size, int colorRGB) {
        CharacterStyle newStyle = new CharacterStyle(font, size, colorRGB);
        for (CharacterStyle style : styles) {
            if (style.equals(newStyle)) {
                return style;
            }
        }
        styles.add(newStyle);
        return newStyle;
    }



}
