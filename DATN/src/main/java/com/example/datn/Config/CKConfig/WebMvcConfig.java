package com.example.datn.Config.CKConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration(value = "WebMvcCkfinder")
public class WebMvcConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //   file:D:\\data\\file\\image\\
        registry.addResourceHandler("/public/image/**").addResourceLocations("/template/uploadmedia/");
         registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        registry.addResourceHandler("/ckfinder/**").addResourceLocations("/template/ckfinder/");
        super.addResourceHandlers(registry);
    }
}
