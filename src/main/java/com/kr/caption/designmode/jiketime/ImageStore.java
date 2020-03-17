package com.kr.caption.designmode.jiketime;

public interface ImageStore {
    String upload(Image image, String bucketName);
    Image download(String url);

}
