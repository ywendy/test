package com.taxchina;

/**
 * @author think
 * @date 2019-01-13 17:58
 */
public class User  implements Cloneable{

    private Long id;
    private String name;


    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
