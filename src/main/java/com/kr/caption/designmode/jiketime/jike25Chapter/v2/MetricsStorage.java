package com.kr.caption.designmode.jiketime.jike25Chapter.v2;

import java.util.List;
import java.util.Map;

/**
 * 注意，一次性取太长时间区间的数据，可能会导致拉取太多的数据到内存中，有可能会撑爆内存。
 * 对于 Java 来说，就有可能会触发 OOM(Out Of Memory)。而且， 即便不出现 OOM，􏰀内存还够用，但也会因为内存吃紧，导致频繁的 Full GC，进而导致系统接口请求处理变慢，甚至超时。
 */
public interface MetricsStorage {

    void saveRequestInfo(RequestInfo requestInfo);

    List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}
