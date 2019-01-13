package com.taxchina;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @date 2019-01-13 18:47
 */
public class Test02 {

    private static final String OUT = "%s,类型：%s,克隆前：%d | %s ,克隆后：%d | %s";


    public static void main(String[] args) throws CloneNotSupportedException {
        //如果是浅克隆，修改Company 的clone 方法
        Company c1 = new Company(1000, "zsw");
        c1.setNum(2000);
        Dept d1 = new Dept(1, "部门1");
        Dept d2 = new Dept(2, "部门2");
        List<Dept> depts = new ArrayList();
        depts.add(d1);
        depts.add(d2);
        c1.setDepts(depts);
        Company c2 = (Company) c1.clone();
        print(c1, c2);
        System.out.println();
        System.out.println("------------------改变包装类型和String类型,重新赋值--------------");
        c2.setId(500);
        c2.setName("zsw01");
        print(c1, c2);
        System.out.println();
        System.out.println("------------------改变引用类型，重新赋值-------------------");
        List<Dept> list = c2.getDepts();
        list.stream().forEach(dept -> {
            dept.setName("研发部");
        });
        print(c1, c2);


    }

    public static void print(Company c1, Company c2) {
        Field[] fields = Company.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                System.out.println(String.format(OUT, field.getName(), field.getGenericType().getTypeName(),
                        UnsafeUtil.getAddress(field.get(c1)), JSON.toJSONString(field.get(c1)),
                        UnsafeUtil.getAddress(field.get(c2)), JSON.toJSONString(field.get(c2))));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


}
