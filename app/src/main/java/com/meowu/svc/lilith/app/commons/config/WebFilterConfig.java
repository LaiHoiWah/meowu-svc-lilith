package com.meowu.svc.lilith.app.commons.config;

import com.meowu.starter.web.security.filter.RequestLogFilter;
import com.meowu.starter.web.security.filter.SecurityContextFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class WebFilterConfig{

    @Bean
    public FilterRegistrationBean<RequestLogFilter> requestFilter(){
        FilterRegistrationBean<RequestLogFilter> registration = new FilterRegistrationBean<RequestLogFilter>();
        registration.setFilter(new RequestLogFilter());
        registration.addUrlPatterns("/api/*");
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registration.setName("requestLogFilter");
        registration.setEnabled(true);

        return registration;
    }

    @Bean
    public FilterRegistrationBean<SecurityContextFilter> securityContextFilter(){
        FilterRegistrationBean<SecurityContextFilter> registration = new FilterRegistrationBean<SecurityContextFilter>();
        registration.setFilter(new SecurityContextFilter());
        registration.addUrlPatterns("/api/*");
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
        registration.setName("securityContextFilter");
        registration.setEnabled(true);

        return registration;
    }
}
