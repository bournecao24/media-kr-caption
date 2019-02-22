package com.kr.caption.normal;


import org.apache.commons.lang3.StringUtils;

/**
 *关于组织code生成规则
 * 每一级占两位用数字字符串表示，第一级为 01
 * 任何一级同级别都自动生成为自增如 0101； 0102
 * 查询列表时候为匹配 01%  查询该组织下所有子组织
 */
public class OrgCodeHelper {

    private static final char minChar = 'a';
    private static final char maxChar = 'z';


    public static String generateCode(String parentCode, String maxBrotherCode) {
        if (StringUtils.isBlank(parentCode) && StringUtils.isBlank(maxBrotherCode)) {
            return "aa";
        }
        if (StringUtils.isBlank(maxBrotherCode)) {
            return parentCode + "aa";
        }
        int len = StringUtils.isBlank(parentCode) ? 0: parentCode.length();
        int curLen = maxBrotherCode.length();
        if (len % 2 != 0 || (curLen - 2) != len) {
            throw new IllegalArgumentException("parentCode must mod 2 is 0");
        }
        return doGenerate(maxBrotherCode);
    }

    private static String doGenerate(String maxBrotherCode) {
        int len = maxBrotherCode.length();
        char lastChar = maxBrotherCode.charAt(len -1);
        char lastSecondChar = maxBrotherCode.charAt(len -2);
        if (lastChar == maxChar) {
            lastSecondChar = (char) (lastSecondChar + 1);
            lastChar = minChar;
        } else {
            lastChar = (char) (lastChar + 1);
        }
        String code = maxBrotherCode.substring(0, len -2) + lastSecondChar + lastChar;
        return code;
    }
}
