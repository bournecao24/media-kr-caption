package com.kr.caption.designmode.jiketime.jike29Chapter;


import javax.transaction.InvalidTransactionException;


/**
 * Transaction 是经过我抽象简化之后的一个电商系统的交易类，用来记录每笔订单交 易的情况。
 * Transaction 类中的 execute() 函数负责执行转账操作，将钱从买家的钱包转到 卖家的钱包中。真正的转账操作是通过调用 WalletRpcService RPC 服务来完成的。
 * 除此 之外，代码中还涉及一个分布式锁 DistributedLock 单例类，用来避免 Transaction 并发执行，导致用户的钱被重复转出
 */
public class Transaction {

    private String id;
    private Long buyerId;
    private Long sellerId;
    private Long productId;
    private String orderId;
    private Long createTimestamp;
    private Double amount;
    private STATUS status;
    private String walletTransactionId;

    private Long days = 0L;


    public Transaction(String preAssignedId, Long buyerId, Long sellerId, Long productId, String orderId) {
        if (preAssignedId != null && !preAssignedId.isEmpty()) {
            this.id = preAssignedId;
        } else {
//            this.id = IdGenerator.generateTransactionId();
            this.id = "";
        }
        if (!this.id.startsWith("t_")) {
            this.id = "t_" + preAssignedId;
        }
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderId = orderId;
        this.status = STATUS.TO_BE_EXECUTED;
        this.createTimestamp = System.currentTimeMillis();
    }

    public boolean execute() throws InvalidTransactionException {
        if ((buyerId == null || (sellerId == null || amount < 0.0))) {
            throw new InvalidTransactionException("");
        }
        if (status == STATUS.EXECUTED) return true;
        boolean isLocked = false;
        try {
//            isLocked = RedisDistributedLock.getSingletonIntance().lockTransction(id);
            if (!isLocked) {
                return false; // 锁定未成功，返回 false，job 兜底执行
            }
            if (status == STATUS.EXECUTED) return true; // double check
            long executionInvokedTimestamp = System.currentTimeMillis();
            if (executionInvokedTimestamp - createTimestamp > days) {
                this.status = STATUS.EXPIRED;
                return false;
            }
            WalletRpcService walletRpcService = new WalletRpcService();
            String walletTransactionId = walletRpcService.moveMoney(id, buyerId, sellerId);
            if (walletTransactionId != null) {
                this.walletTransactionId = walletTransactionId;
                this.status = STATUS.EXECUTED;
                return true;
            } else {
                this.status = STATUS.FAILED;
                return false;
            }
        } finally {
            if (isLocked) {
//                RedisDistributedLock.getSingletonIntance().unlockTransction(id);
            }
        }
    }

}
