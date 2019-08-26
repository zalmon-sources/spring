package com.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by peng.zhang
 * Description: 配置DispatcherServlet,取代web.xml的方案，只能部署到支持Servlet 3.0的服务器，tomcat7过更高
 * Time: 2019/8/21-16:30.
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 用来配置ContextLoaderListener创建的应用上下文中的bean。
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * 制定配置类，用来定义DispatcherServlet应用上下文中的bean
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * 将 DispatcherServlet映射到 /
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
