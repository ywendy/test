package com.taxchina;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }


    private void writeObject(ObjectOutputStream out)  {

        throw new RuntimeException("不允许");
    }

    private void readObject(ObjectInputStream in)  {
        throw new RuntimeException("不允许");
    }
}
