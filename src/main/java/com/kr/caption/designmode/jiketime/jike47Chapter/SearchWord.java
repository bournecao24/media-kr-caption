package com.kr.caption.designmode.jiketime.jike47Chapter;

public class SearchWord {

    private String keyword;
    private String count;
    private Integer lastUpdateTime;

    public SearchWord(String keyword, Integer lastUpdateTime, String count) {
        this.keyword = keyword;
        this.lastUpdateTime = lastUpdateTime;
        this.count = count;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Integer lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
