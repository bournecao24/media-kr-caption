package com.kr.caption.designmode.jiketime.jike54Chapter.example2;

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

    /**
     * 每敲一个文字，都会调用 Editor 类中的 appendCharacter() 方法，创建一个新的 Character 对象，保存到 chars 数组中。如果一个文本文件中，有上万、十几万、几十万的文字，那我们就要在内存中存储这么多 Character 对象
     *
     * @param c
     * @param font
     * @param size
     * @param colorRGB
     */
    public void appendCharacter(char c, Font font, int size, int colorRGB) {
        Character character = new Character(c, font, size, colorRGB);
        chars.add(character);
    }
}
