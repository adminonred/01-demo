package com.cn.config;

import com.cn.filter.MyFilter;
import com.cn.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class webApplicationConfig {
    @Bean
    public FilterRegistrationBean getFilter(){
        FilterRegistrationBean filter=new FilterRegistrationBean();
        filter.addUrlPatterns("/*");
        filter.setFilter(new MyFilter());
        return filter;
    }
    @Bean
    public ServletRegistrationBean getServlet(){
        ServletRegistrationBean servlet=new ServletRegistrationBean(new MyServlet(),"/myservlet");
        return servlet;
    }
}
