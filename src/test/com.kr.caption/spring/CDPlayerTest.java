package com.kr.caption.spring;


import com.kr.caption.spring.orginal.CDPlayerConfig;
import com.kr.caption.spring.orginal.Compactdic;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private Compactdic cd;


    @Test
    public void cdShouldNotBeNull(){
        Assert.assertNotNull(cd);
        Assert.assertNull(cd);
    }

}
