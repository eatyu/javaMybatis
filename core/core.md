参考资料 https://blog.csdn.net/qq_41534566/article/details/79088129
    https://blog.csdn.net/lchpersonal521/article/details/84451357
这个文章对mybatis利用jdk动态代理有介绍，但是具体还是要参照源码。对sqlsession动态代理。

![Image text](https://raw.githubusercontent.com/eatyu/javaMybatis/master/core/src/img/11182357_N86c.jpg)


这是mybatis的一张架构图，从中我们可以看得出。应用程序去调用对应的db操作时会经历 配置->打开会话->在会话中执行相应的操作，同时会话中包含了jdbc的事务(对，没错。就是jdbc的事务)。那么我们可以看得出来，会话是核心。而配置是关键  


![Image text](https://raw.githubusercontent.com/eatyu/javaMybatis/master/core/src/img/1352849-20180729204649421-1202779896.png)
这个是mybatis配置流程图


整个代理对象生成过程可以用如下时序图表示  
![Image text](https://raw.githubusercontent.com/eatyu/javaMybatis/master/core/src/img/2018112418124956.png)

查询阶段的时序图  
![Image text](https://raw.githubusercontent.com/eatyu/javaMybatis/master/core/src/img/20181124181343659.png)






我们要构建一个sqlsession的时候会使用 SqlSessionFactoryBuilder 这个类，通过传递一个抽象的Reader对象(是不是很眼熟？这玩意就是IO流里的字节流基类), 通过这个玩意传一个xml文件进来  
然后去构建一个SqlSessionFactory对象。  

更多的是看源码了，这里不多bb了，下面贴一段源码里比较骚气的代码，这里的mybatis的版本是3.4.6  
![Image text](https://raw.githubusercontent.com/eatyu/javaMybatis/master/core/src/img/mybatisversion.png)
![Image text](https://raw.githubusercontent.com/eatyu/javaMybatis/master/core/src/img/mybatis%E9%AA%9A%E6%B0%94%E4%BB%A3%E7%A0%81.png)