package com.kr.caption.java8.parallel;

import java.util.Spliterator;
import java.util.function.Consumer;

public class WordCounterSpliterator implements Spliterator<Character> {

    private final String string;
    private int currentChar = 0;

    public WordCounterSpliterator(String string) {
        this.string = string;
    }


    /**
     * 处理当前字符，如果还有需要处理的字符，就返回true
     *
     * @param action
     * @return
     */
    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length();
    }


    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if (currentSize < 10) {   //自定义一个最小的拆分尺寸
            return null;  //返回null表示要 解 析 的 String 已经足够小，可 以顺序处理
        }


        //将试探拆分 位置设定为 要解析的 String的中 间
        for (int splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++) {
            //让拆分位置 前进直到下 一个空格
            if (Character.isWhitespace(string.charAt(splitPos))) {

                //创建一个新的WordCounterSpliterator来解析String 从开始到拆分 位置的部分
                WordCounterSpliterator spliterator = new WordCounterSpliterator(string.substring(currentChar, splitPos));
                //将这个对象的起始位置设置为拆分位置
                currentChar = splitPos;
                return spliterator;
            }
        }
        return null;
    }


    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return 0;
    }
}
