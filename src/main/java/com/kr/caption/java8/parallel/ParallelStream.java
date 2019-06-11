package com.kr.caption.java8.parallel;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStream {



    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    /**
     * 将顺序流转换为并行流
     *
     * @param n
     * @return
     */
    private static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }


    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    //LongStream直接产生原始类型的long数字，没有装箱拆箱的开销； 而且会生成数字范围，很容易拆分为独立的小块
    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
    }

    //选择适当的数据结构往往比并 行化算法更重要
    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }



    public static void main(String[] args) {
        System.out.println("Sequential sum done in:" + measureSumPerf(ParallelStream::parallelRangedSum, 10_000_000) + " msecs");
        //结果是并行的更慢，原因：iterate 生成的是装箱操作，必须拆箱成数字才能求和； 很难把iterate分成多个块来执行，因为后一步操作会依赖前一步的结果。
    }
}
