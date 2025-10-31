package com.meowu.svc.lilith.app.commons.config;

import com.meowu.starter.web.mvc.convert.StringToLocaleConverter;
import com.meowu.starter.web.mvc.convert.StringToRecordStatusConverter;
import com.meowu.starter.web.mvc.convert.StringToSeverityLevelConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/api/**")
                .allowedOriginPatterns(CorsConfiguration.ALL)
                .allowedHeaders(CorsConfiguration.ALL)
                .allowedMethods(
                    HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.PATCH.name(),
                    HttpMethod.PUT.name(), HttpMethod.DELETE.name(), HttpMethod.OPTIONS.name()
                )
                .allowCredentials(true);
    }

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(new StringToRecordStatusConverter());
        registry.addConverter(new StringToSeverityLevelConverter());
        registry.addConverter(new StringToLocaleConverter());
    }
}
