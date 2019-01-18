package com.taxchina;

import java.io.*;

/**
 * @author think
 * @date 2019-01-18 17:01
 */
public class Test10 {


    public static void main(String[] args) {

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos)) {


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
