package com.jmybatis.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@Component
@MapperScan("com.jmybatis.core.dao")
public class MapperConfig {
}
