package com.wywhdgg.mvc.clone;

/**
 * @author: dongzhb
 * @date: 2019/11/29
 * @Description:
 */
public class CloneTest {

    public static void main1(String[] args) throws CloneNotSupportedException {
        School s1 = new School();
        s1.setSchoolName("实验小学");
        s1.setStuNums(100);
        Student stu1 = new Student();
        stu1.setAge(20);
        stu1.setName("zhangsan");
        stu1.setSex(new StringBuffer("男"));
        s1.setStu(stu1);
        System.out.println("s1: " + s1 + " s1的hashcode:" + s1.hashCode() + "  s1中stu1的hashcode:" + s1.getStu().hashCode());
        School s2 = s1.clone();  //调用重写的clone方法，clone出一个新的school---s2
        System.out.println("s2: " + s2 + " s2的hashcode:" + s2.hashCode() + " s2中stu1的hashcode:" + s2.getStu().hashCode());
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        School s1 = new School();
        s1.setSchoolName("实验小学");
        s1.setStuNums(100);
        Student stu1 = new Student();
        stu1.setAge(20);
        stu1.setName("zhangsan");
        stu1.setSex(new StringBuffer("男"));
        s1.setStu(stu1);
        System.out.println("s1: " + s1 + " s1的hashcode:" + s1.hashCode() + "  s1中stu1的hashcode:" + s1.getStu().hashCode());
        School s2 = s1.clone();  //调用重写的clone方法，clone出一个新的school---s2
        System.out.println("s2: " + s2 + " s2的hashcode:" + s2.hashCode() + " s2中stu1的hashcode:" + s2.getStu().hashCode());

        //修改s2中的值,看看是否会对s1中的值造成影响
        s2.setSchoolName("希望小学");
        s2.setStuNums(200);
        Student stu2 = s2.getStu();
        stu2.setAge(30);
        stu2.setName("lisi");
        stu2.setSex(stu2.getSex().append("6666666"));
        s2.setStu(stu2);

        //再次打印两个school，查看结果
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("s1: " + s1 + " hashcode:" + s1.hashCode() + "  s1中stu1的hashcode:" + s1.getStu().hashCode());
        System.out.println("s2: " + s2 + " hashcode:" + s2.hashCode() + " s2中stu1的hashcode:" + s2.getStu().hashCode());


    }

}
