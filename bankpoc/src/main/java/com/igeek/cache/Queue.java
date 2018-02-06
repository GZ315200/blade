package com.igeek.cache;

import com.igeek.bean.Message;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Gyges Zean
 * @date 2018/2/2
 */
public class Queue {

    public static java.util.Queue<List<Message>> queue = new LinkedBlockingDeque<>();
}
