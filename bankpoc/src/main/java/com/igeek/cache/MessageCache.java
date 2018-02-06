package com.igeek.cache;

import com.google.common.collect.Maps;
import com.igeek.bean.Message;

import java.util.List;
import java.util.Map;

/**
 * @author Gyges Zean
 * @date 2018/2/2
 */
public class MessageCache {

    public static Map<Object, List<Message>> cache = Maps.newConcurrentMap();
}
