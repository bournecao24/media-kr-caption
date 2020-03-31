//package com.kr.caption.designmode.jiketime.jike43Chapter;
//
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicLong;
//
///**
// * 集群内唯一
// */
//public class IdGeneratorV2 {
//    private AtomicLong id = new AtomicLong(0);
//    private static IdGenerator instance;
//    private static SharedObjectStorage storage = FileSharedObjectStorage();//入参省略
//    private static DistributedLock lock = new DistributedLock();
//    private IdGeneratorV2() {
//    }
//
//    public synchronized static IdGenerator getInstance() {
//        if (instance == null) {
//            lock.lock();
//            instance = storage.load(IdGenerator.class);
//        }
//        return instance;
//    }
//
//    public synchronized void freeInstance() {
//        storage.save(this, IdGeneratorV2.class);
//        instance = null; //释放对象 lock.unlock();
//    }
//    public long getId() {
//        return id.incrementAndGet();
//    }
//}