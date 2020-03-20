package com.kr.caption.designmode.jiketime.jike19Chapter;

import java.util.ArrayList;
import java.util.List;

public class JunitApplication {
    private static final List<TestCase> testCases = new ArrayList<>();

    public static void register(TestCase testCase) {
        testCases.add(testCase);
    }

    public static final void main(String[] args) {
        for (TestCase singleCase : testCases) {
            singleCase.run();
        }
    }
}
