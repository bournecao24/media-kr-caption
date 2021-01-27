package com.kr.caption.commonMistakes.jike1Chapter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: caozhenlong
 * @Date: 2021-01-23
 * @Description:
 */

@Controller
@RequestMapping("/thread/local/")
public class ThreadTest {

    private ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(() -> null);




}
