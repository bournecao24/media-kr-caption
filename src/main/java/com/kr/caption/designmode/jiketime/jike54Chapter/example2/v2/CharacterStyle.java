package com.kr.caption.designmode.jiketime.jike54Chapter.example2.v2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;

/**
 * 在一个文本文件中，用到的字体格式不会太多，毕竟不大可能有人把每个文字都设置成不同的格式。所以，对于字体格式，我们可以将它设计成享元，让不同的文字共享使用。
 *
 * @Author: caozhenlong
 * @Date: 2021-01-26
 * @Description:
 */
@Data
@AllArgsConstructor
public class CharacterStyle {

    private Font font;
    private int size;
    private int colorRGB;

    @Override
    public boolean equals(Object o) {
        CharacterStyle otherStyle = (CharacterStyle) o;
        return font.equals(otherStyle.font) && size == otherStyle.size && colorRGB == otherStyle.colorRGB;
    }
}
