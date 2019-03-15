参考资料 https://blog.csdn.net/qq_41534566/article/details/79088129


![Image text](https://raw.githubusercontent.com/eatyu/javaMybatis/master/core/src/main/11182357_N86c.jpg)

这是mybatis的一张架构图，从中我们可以看得出。应用程序去调用对应的db操作时会经历 配置->打开会话->在会话中执行相应的操作，同时会话中包含了jdbc的事务(对，没错。就是jdbc的事务)。那么我们可以看得出来，会话是核心。而配置是关键  




我们要构建一个sqlsession的时候会使用 SqlSessionFactoryBuilder 这个类，通过传递一个抽象的Reader对象(是不是很眼熟？这玩意就是IO流里的字节流基类), 通过这个玩意传一个xml文件进来  
然后去构建一个SqlSessionFactory对象。  

更多的是看源码了，这里不多bb了，下面贴一段源码里比较骚气的代码，这里的mybatis