package com.kr.caption.java8.parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;


/**
 * 有返回接口用 RecursiveTask<R>， 没有返回结果用 RecursiveAction
 * 当把ForkJoinSumCalculator任务传给ForkJoinPool时，这个任务就由池中的一个线程 执行，这个线程会调用任务的compute方法。
 * 该方法会检查任务是否小到足以顺序执行，如果不 够小则会把要求和的数组分成两半，分给两个新的ForkJoinSumCalculator，
 * 而它们也由 ForkJoinPool安排执行。因此，这一过程可以递归重复，把原任务分为更小的任务，
 * 直到满足 不方便或不可能再进一步拆分的条件(本例中是求和的项目数小于等于10 000)。这时会顺序计 算每个任务的结果，
 * 然后由分支过程创建的(隐含的)任务二叉树遍历回到它的根
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;

    public static final long THRESHOLD = 10_000;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    public ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length < THRESHOLD) {
            return computeSequentially();
        }

        //创建一个任务为数组的前一半求和
        ForkJoinSumCalculator leftTask =
                new ForkJoinSumCalculator(numbers, start, start + length / 2);
        //利用另一个ForkJoinPool线程异步执行新创建的子任务
        leftTask.fork();

        //创建一个任务为数组的后一半求和
        ForkJoinSumCalculator rightTask =
                new ForkJoinSumCalculator(numbers, start + length / 2, end);

        //同步执行第二个子 任务，有可能允许进 一步递归划分
        Long rightResult = rightTask.compute();

        //读取第一个子任务的结果，如果尚未完成就等待
        Long leftResult = leftTask.join();

        return leftResult + rightResult;
    }


    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }


    /**
     * 只需要把ForkJoinPool实例化一次，保存在静态的变量中，全局都能用
     * @param n
     * @return
     */
    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(forkJoinSum(100_000_000));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Result: " + duration);

    }
}
