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
public class School  {//implements Cloneable
    private String schoolName;   //学校名称
    private int stuNums;         //学校人数
    private Student stu;         //一个学生

    @Override
    public String toString() {
        return "School [schoolName=" + schoolName + ", stuNums=" + stuNums + ", stu=" + stu + "]";
    }

    @Override
    protected School clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        School s = null;
        s = (School)super.clone();
        s.stu = stu.clone();
        return s;
    }

}
