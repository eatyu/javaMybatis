package com.jmybatis.helper.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@Component
@MapperScan("com.jmybatis.helper.dao")
public class MapperConfig {
}
