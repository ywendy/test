package com.taxchina;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author think
 * @date 2019-01-14 00:15
 */
public class Animal implements Serializable {
    private static final long serialVersionUID = 3607896278127298777L;
    private Integer id;
    private String name;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Animal() {
    }

    public Animal(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     *
     * 序列化时实现下面两个方法会自动被调用，可以用来自定义序列化
     *
     */

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(id);
        out.writeObject(name);
        //throw new RuntimeException("不允许序列化这个类");
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.id = in.readInt();
        this.name = in.readObject().toString();
       //throw new RuntimeException("不允许反序列化");
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
