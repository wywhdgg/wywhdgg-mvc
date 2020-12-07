1.bean增加别名支持
   bean除了标识唯一的名称，还可以有任意个别名，别名也使唯一的
2.beanFactory 增加可按class获取Bean对象功能

3.加入配置参数加载，注入给bean的功能。
    配置文件
4.加入Bean配置的条件依赖生效支持
   在bean定义的配置中可以指定它条件依赖某些bean或者类，当这些bean类存在时，这个bean配置才生效。
   
AOP增强功能标准定义：
   
   Advice 通知，增强的功能
   Join points 连接点，可选择的方法
   Pointcut 切入点，选择切入的方法点
   Aspect 切面，选择的方法点+增强的功能
   Introduction  引入：添加新的方法，属性到已存在的类中，就叫引入
   Weaving 织入（编辑） :不改变原来的代码，加入功能的增强。
   
表达式的官网：   
Aspect:jhttps://www.eclipse.org/aspectj/


sping官网的AOP:
https://docs.spring.io/spring/docs/5.1.1.RELEASE/spring-framework-reference/core.html#aop-pointcuts