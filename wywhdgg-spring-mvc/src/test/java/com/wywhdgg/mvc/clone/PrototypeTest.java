package com.wywhdgg.mvc.clone;

/**
 * @author: dongzhb
 * @date: 2019/11/29
 * @Description:

四 原型模式的实际应用案例
(1) 原型模式应用于很多软件中，如果每次创建一个对象要花大量时间，原型模式是最好的解决方案。
很多软件提供的复制(Ctrl + C)和粘贴(Ctrl + V)操作就是原型模式的应用，复制得到的对象与原型对象是两个类型相同但内存地址不同的对象，
通过原型模式可以大大提高对象的创建效率。

(2) 在Struts2中为了保证线程的安全性，Action对象的创建使用了原型模式，访问一个已经存在的`Action对象时将通过克隆的方式创建出一个新的对象，
从而保证其中定义的变量无须进行加锁实现同步，每一个Action中都有自己的成员变量，避免Struts1因使用单例模式而导致的并发和同步问题。

(3) 在Spring中，用户也可以采用原型模式来创建新的bean实例，从而实现每次获取的是通过克隆生成的新实例，
对其进行修改时对原有实例对象不造成任何影响。


模式优缺点分析
原型模式的优点：

当创建新的对象实例较为复杂时，使用原型模式可以简化对象的创建过程，通过一个已有实例可以提高新实例的创建效率。
可以动态增加或减少产品类。
原型模式提供了简化的创建结构。
可以使用深克隆的方式保存对象的状态。
原型模式的缺点：

需要为每一个类配备一个克隆方法，而且这个克隆方法需要对类的功能进行通盘考虑，这对全新的类来说不是很难，
但对已有的类进行改造时，不一定是件容易的事，必须修改其源代码，违背了“开闭原则”。
在实现深克隆时需要编写较为复杂的代码。

 */
public class PrototypeTest {

    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen underlinePen=new UnderlinePen('~');
        MessageBox mbox=new MessageBox('*');
        MessageBox sbox=new MessageBox('/');
        manager.register("Strong message", underlinePen);
        manager.register("Waring Box", mbox);
        manager.register("Slash Box", sbox);
        Product p1=manager.create("Strong message");
        p1.use("hello world");
        Product p2=manager.create("Waring Box");
        p2.use("hello world");
        Product p3=manager.create("Slash Box");
        p3.use("hello world");
    }

}
