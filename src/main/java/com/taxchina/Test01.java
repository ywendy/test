package com.taxchina;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author think
 * @date 2019-01-13 18:00
 */
public class Test01 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class c1 = Class.forName("com.taxchina.User");
        User user1 = (User) c1.newInstance();
        user1.setId(1L);
        user1.setName("1");
        System.out.println("user1="+user1);

        Constructor<User> constructor = c1.getConstructor(Long.class, String.class);
        User user2 = constructor.newInstance(2L, "2");
        System.out.println("user2="+user2);

    }

}
