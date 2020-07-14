package algorithm;

import com.kr.caption.algorithm.lru.ArrayQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class LruTest {
    private static Logger logger = LogManager.getLogger(LruTest.class);


    @Test
    public void test(){
        final ArrayQueue<String> queue = new ArrayQueue(4);

        new Thread(() -> {

            try {
                logger.info("{" + Thread.currentThread().getName() + "}" + queue.get());
            }catch (Exception e){
            }
        }).start();

        queue.put("1");
        queue.put("12");
        queue.put("123");
        queue.put("1234");

        logger.info("size={}", queue.count);

        while (queue.count > 0){
            logger.info(queue.get());
        }
    }








}
