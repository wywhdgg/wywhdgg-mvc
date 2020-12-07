package com.wywhdgg.mvc.clone;

/**
 * @author: dongzhb
 * @date: 2019/11/29
 * @Description:
3.1 Prototype（抽象原型类）
Product角色负责定义用于复制现有实例来生成新实例的方法。在示例程序中的Product接口就是该角色。

3.2 ConcretePrototype（具体原型类）
ConcretePrototype角色负责实现复制现有实例并生成新实例的方法。在示例程序中，MessageBox和UnderlinePen都是该角色。

3.3 Client（客户类/使用者）
Client角色负责使用复制实例的方法生成新的实例。在示例程序中，Manager类扮演的就是该角色。
 */
public interface Product extends Cloneable {
    //use方法是用于“使用”的方法，具体怎么“使用”，则被交给子类去实现。
    public abstract void use(String s);
    //creatClone方法是用于复制实例的方法
    public abstract Product creatClone();
}
