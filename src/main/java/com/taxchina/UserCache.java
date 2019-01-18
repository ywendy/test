package com.taxchina;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class UserCache {

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.WriteLock  writeLock = lock.writeLock();
    private static ReentrantReadWriteLock.ReadLock  readLock = lock.readLock();

    private static final Map<String,User> USER_CACHE = new HashMap<>();



    public  static User get(String key){
        readLock.lock();
        try{
            return   USER_CACHE.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public  static void update(String key,User user){
        writeLock.lock();
        try {
            USER_CACHE.put(key, user);
        }finally {
            writeLock.unlock();
        }
    }


}
