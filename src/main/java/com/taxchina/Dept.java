package com.taxchina;

import java.io.Serializable;

/**
 * @author think
 * @date 2019-01-13 19:01
 */
public class Dept implements Cloneable,Serializable {


    private static final long serialVersionUID = -6050739611886531724L;
    private Integer id;
    private String name;

    public Dept() {
    }

    public Dept(Integer id, String name) {
        this.id = id;
        this.name = name;
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
