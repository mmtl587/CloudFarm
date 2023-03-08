package com.example.CloudFarm.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    //获取真实路径和访问路径
    @Value("${thk.imagesRealPath}")
    private String realPath;
    @Value("${thk.imagesServerPath}")
    private String serverPath;

    //添加文件服务器位置
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(new String[]{serverPath + "/**"}).addResourceLocations("file:/" + realPath);
    }
}
