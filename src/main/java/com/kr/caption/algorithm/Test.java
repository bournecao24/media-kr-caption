package com.kr.caption.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Test {


    private static final Integer LIMIT_NUM = 20;

    private void subListSkill() {

        List<String> list = new ArrayList<>(100);

        if (list.size() > LIMIT_NUM) {
            int part = list.size() / LIMIT_NUM;
            for (int i = 0; i < part; i++) {
                List<String> taskBatchList = list.subList(0, LIMIT_NUM);
                //to do something
                list.subList(0, LIMIT_NUM).clear();
            }
        }

        if (list.size() > 0) {
            //to do something
            list.clear();
        }
    }


}
