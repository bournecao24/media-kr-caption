package com.kr.caption.designmode.jiketime.jike53Chapter.v2;

public abstract class FileSystemNode {
    protected String path;

    public FileSystemNode(String path) {
        this.path = path;
    }

    public abstract int countNumOfFiles();

    public abstract long countSizeOfFiles();

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
