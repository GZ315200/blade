package com.igeek.lock;

import org.redisson.api.RedissonClient;


/**
 * @author Gyges Zean
 * @date 2018/3/9
 */
public class RedissonLockManager {

    private RedissonClient redisson;

    public RedissonLockManager (RedissonClient redisson) {
        if (null == redisson) {
            throw new NullPointerException();
        }
        this.redisson = redisson;
    }


}


