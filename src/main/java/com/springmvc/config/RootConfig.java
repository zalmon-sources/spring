package com.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by peng.zhang
 * Description: 配置 servlet监听器，另一个应用上下文：ContextLoaderListener
 * Time: 2019/8/26-15:10.
 */

@Configuration
@ComponentScan(basePackages={"com.springmvc"},
        excludeFilters={
                @ComponentScan.Filter(type= FilterType.ANNOTATION, value=EnableWebMvc.class)
        })
public class RootConfig {
}
