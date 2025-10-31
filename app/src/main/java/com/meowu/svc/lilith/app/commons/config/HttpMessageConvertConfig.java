package com.meowu.svc.lilith.app.commons.config;

import com.google.gson.GsonBuilder;
import com.meowu.starter.commons.utils.GsonUtils;
import com.meowu.starter.entity.adapter.gson.*;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.nio.charset.StandardCharsets;

@Configuration
public class HttpMessageConvertConfig{

    @Bean
    public HttpMessageConverters gsonConverter(){
        // adapters
        TypeAdapter<?>[] typeAdapters = new TypeAdapter<?>[]{
            new DateAdapter(), new RecordStatusAdapter(), new SeverityLevelAdapter(), new LocaleAdapter()
        };
        // gson builder
        GsonBuilder builder = GsonUtils.getBuilder(true, true, typeAdapters);
        // converter
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(builder.create());
        converter.setDefaultCharset(StandardCharsets.UTF_8);
        return new HttpMessageConverters(converter);
    }
}
