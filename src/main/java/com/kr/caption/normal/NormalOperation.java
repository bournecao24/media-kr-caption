package com.kr.caption.normal;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NormalOperation {

    /**
     * 将集合的id转换为英文逗号间隔的字符串
     * @param articleId
     * @return
     */
    protected String converterString(List<Long> articleId){
        StringBuilder builder = new StringBuilder();
        for (Iterator<Long> iterator = articleId.iterator(); iterator.hasNext(); ) {
            String str = String.valueOf(iterator.next());
            builder.append(str);
            if (iterator.hasNext()) {
                builder.append(",");
            }
        }
        return builder.toString();
    }

    /**
     * 取集合中重复的元素
     * @return
     */
    protected List<Long> getDulicateElement(){
        String articleId = "10464271,5140193,531621,5140192,5050325,5049818,5049809";
        String[] ids = articleId.split(",");

       return Arrays.stream(ids).collect(Collectors.groupingBy(item -> item))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1)
                .map(Map.Entry::getKey).map(Long::valueOf).collect(Collectors.toList());
    }
}
