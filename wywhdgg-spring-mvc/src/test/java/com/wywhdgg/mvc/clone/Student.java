package com.wywhdgg.mvc.clone;

import lombok.Data;
import lombok.ToString;

/**
 * @author: dongzhb
 * @date: 2019/11/29
 * @Description:
 */
@Data
@ToString
public class Student {//implements Cloneable
    private String name;   //姓名
    private int age;       //年龄
    private StringBuffer sex;  //性别


    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", sex=" + sex + "]";
    }


    @Override
    protected Student clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return (Student)super.clone();
    }

}
