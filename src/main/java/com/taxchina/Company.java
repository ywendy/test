package com.taxchina;

import java.io.*;
import java.util.List;

/**
 * @author think
 * @date 2019-01-13 19:00
 */
public class Company  implements Cloneable,Serializable {

    private static final long serialVersionUID = 2009216156945244251L;
    private Integer id;
    private String name;
    private int num;//公司人数
    private List<Dept> depts;

    public Company() {
    }

    @Override
    protected Object clone()  {
        //浅克隆
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return  this;
        //深克隆
/*

        try( ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(this);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return  ois.readObject();
        } catch (IOException  | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return this;
*/


    }

    public Company(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public List<Dept> getDepts() {
        return depts;
    }

    public void setDepts(List<Dept> depts) {
        this.depts = depts;
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
