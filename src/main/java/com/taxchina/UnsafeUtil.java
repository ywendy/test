package com.taxchina;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author think
 * @date 2019-01-13 19:27
 */
public final class UnsafeUtil {
    private static Unsafe UNSAFE;



    static {
        try {
            Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            UNSAFE = (Unsafe) unsafeField.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            UNSAFE = null;
        }
    }

    public static Unsafe getUnsafe() {
        return UNSAFE;
    }



    public static long getAddress(Object object)  {
        Object[] array = new Object[] {object};
        long baseOffset = UNSAFE.arrayBaseOffset(Object[].class);
        if (UNSAFE.addressSize() == 4 ){
            return UNSAFE.getInt(array,baseOffset);
        }else if (UNSAFE.addressSize() == 8){
            return UNSAFE.getLong(array,baseOffset);
        }else{
            return -1;
        }

    }



}
