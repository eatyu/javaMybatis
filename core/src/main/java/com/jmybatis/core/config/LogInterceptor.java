package com.jmybatis.core.config;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

/**
 * 实现mybatis log拦截器
 * // 3.40之后的写法 多了一个Integer.class的参数
 *
 *
 */
/**该注解签名告诉此拦截器拦截四大对象中的哪个对象的哪个方法，以及方法的签名信息*/
//@Intercepts(value = {@Signature(type = StatementHandler.class, method = "prepare",
//        args = {Connection.class,Integer.class})})
@Intercepts(value = {@Signature(type = StatementHandler.class, method = "query",
        args = {Statement.class, ResultHandler.class})
})
public class LogInterceptor implements Interceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        logger.info("%%% intercept");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        logger.info("%%% plugin");
        return target instanceof StatementHandler ? Plugin.wrap(target, this) : target;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
