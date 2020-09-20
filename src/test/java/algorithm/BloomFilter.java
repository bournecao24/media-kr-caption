package algorithm;

import com.google.common.hash.Funnels;
import org.junit.Assert;
import org.junit.Test;

public class BloomFilter {


    /**
     * 构造方法中有两个比较重要的参数，一个是预计存放多少数据，一个是可以接受的误报率，Guava 会通过你预计的数量以及误报率帮你计算出你应当会使用的数组大小 numBits 以及需要计算几次 Hash 函数 numHashFunctions
     */
    @Test
    public void guavaTest() {
        long star = System.currentTimeMillis();
        com.google.common.hash.BloomFilter<Integer> filter = com.google.common.hash.BloomFilter.create(
                Funnels.integerFunnel(),
                10000000,
                0.01);

        for (int i = 0; i < 10000000; i++) {
            filter.put(i);
        }

        Assert.assertTrue(filter.mightContain(1));
        Assert.assertTrue(filter.mightContain(2));
        Assert.assertTrue(filter.mightContain(3));
        Assert.assertFalse(filter.mightContain(10000000));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));
    }

}
