package com.kr.caption.java8.parallel;

import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * 单词计数器
 */
public class WordCounter {

    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    private WordCounter accumulate(Character c) {

        if (Character.isWhitespace(c)) {
            return lastSpace ? this : new WordCounter(counter, true);
        } else {
            return lastSpace ? new WordCounter(counter + 1, false) : this;  //上一个字符是空格，当前的不是空格，原有的数+1，置为false
        }

    }

    /**
     * 加和
     *
     * @param counter
     * @return
     */
    private WordCounter combine(WordCounter counter) {
        return new WordCounter(counter.counter + 1, counter.lastSpace);
    }

    private static int getWordCounter(Stream<Character> stream) {
        WordCounter reduce = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
        return reduce.counter;
    }


    public static void main(String[] args) {
        final String SENTENCE = " Nel   mezzo del cammin  di nostra  vita " +
                "mi  ritrovai in una  selva oscura" +
                " ché la  dritta via era   smarrita ";

        Stream<Character> stream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);


        System.out.println(getWordCounter(stream));
        System.out.println(getWordCounter(stream.parallel()));

        System.out.println(SENTENCE.charAt(3));


    }
}
