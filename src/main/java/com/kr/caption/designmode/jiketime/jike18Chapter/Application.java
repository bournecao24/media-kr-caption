package com.kr.caption.designmode.jiketime.jike18Chapter;

public class Application {

    static ConfigSource configSource = new ZookeeperConfigSource(/* 省略参数 */);
    public static final RedisConfig redisConfig = new RedisConfig(configSource);

    //    public static final KafkaConfig kafkaConfig = new KakfaConfig(configSource);
//    public static final MySqlConfig mysqlConfig = new MysqlConfig(configSource);
    public static void main(String[] args) {
        ScheduledUpdater redisConfigUpdater = new ScheduledUpdater(redisConfig, 300, 1);
        redisConfigUpdater.run();
//        ScheduledUpdater kafkaConfigUpdater = new ScheduledUpdater(kafkaConfig, 60
//                redisConfigUpdater.run(); }


        SimpleHttpServer simpleHttpServer = new SimpleHttpServer("127.0 .0 .1", 2345);
        simpleHttpServer.addViewers("/config", redisConfig);
//         simpleHttpServer.addViewers("/config", mysqlConfig);
        simpleHttpServer.run();
    }
}