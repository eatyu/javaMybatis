package com.jmybatis.core.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

/**
 * springboot1.4取消spring.datasource.type
 */
//@Configuration
//@ConfigurationProperties(prefix = "spring.datasource")
public class DruidConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(DruidConfiguration.class);

    private String name;
    private String url;
    private String username;
    private String password;
    private String type;
    private String driverClassName;
    private String filters;
    private int maxActive;
    private int initialSize;
    private int maxWait;
    private int minIdle;
    private int timeBetweenEvictionRunsMillis;
    private int minEvictableIdleTimeMillis;
    private boolean testWhileIdle;
    private String validationQuery;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxOpenPreparedStatements;

    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        dataSource.setMaxActive(maxActive);
//        dataSource.setInitialSize(initialSize);
//        dataSource.setMaxWait(maxWait);
//        dataSource.setMinIdle(minIdle);
//        dataSource.setTimeBetweenConnectErrorMillis(timeBetweenEvictionRunsMillis);
//        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
//        dataSource.setFilters("mergeStat,wall,log4j");//mergeStat代替stat表示sql合并,wall表示防御SQL注入攻击
        return dataSource;
    }

    @Bean
    @Profile({"localdev", "remotetest"})
    public ServletRegistrationBean druidServlet() {
        LOGGER.info("\n********************************************************\n\n加载druid " +
                "servlet\n\n********************************************************");
        return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
    }

    @Bean
    @Profile({"localdev", "remotetest"})
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
