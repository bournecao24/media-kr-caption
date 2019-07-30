package com.kr.caption.spring.orginal;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * autowired 不仅能够用在构造方法中，还能用在set方法中
 * required = false  设置之后，如果装配不了，就不装配
 */
public class CDPlayer {


    private Compactdic cd;

    @Autowired(required = false)
    public CDPlayer(Compactdic cd) {
        this.cd = cd;
    }


    @Autowired
    public void setCd(Compactdic cd) {
        this.cd = cd;
    }
}
