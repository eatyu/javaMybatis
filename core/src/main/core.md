参考资料 https://blog.csdn.net/qq_41534566/article/details/79088129


![Image text](https://raw.githubusercontent.com/eatyu/javaMybatis/master/core/src/main/11182357_N86c.jpg)

这是mybatis的一张架构图，从中我们可以看得出。应用程序去调用对应的db操作时会经历 配置->打开会话->在会话中执行相应的操作，同时会话中包含了jdbc的事务(对，没错。就是jdbc的事务)。那么我们可以看得出来，会话是核心。而配置是关键  
