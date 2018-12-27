package com.kr.caption.redis;

import com.kr.caption.util.redis.standalone.RedisStandaloneBuilder;
import com.kr.caption.util.redis.standalone.RedisStandaloneCallback;
import com.kr.caption.util.redis.standalone.RedisStandaloneTemplate;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedisStandaloneTest {

    private RedisStandaloneTemplate template;

    @Before
    public void setUp() {
        RedisStandaloneBuilder builder = new RedisStandaloneBuilder();
        builder.setHost("192.168.2.14");
        builder.setPort(6379);
        builder.setPassword("123456");

        template = new RedisStandaloneTemplate();
        template.setRedisBuilder(builder);
    }

    @Test
    public void execute(){

        template.execute(new RedisStandaloneCallback<Boolean>() {
            @Override
            public Boolean doCallback(Jedis jedis) {
//                jedis.set("chaoji", "superman");
//                String chaoji = jedis.get("chaoji");
                jedis.del("chaoji");
//                System.out.println(chaoji);
                return true;
            }
        });


    }
}
