package com.example.CloudFarm.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:message.properties", encoding = "UTF-8")
public class MessagePropertise {

    private final Environment environment;

    public MessagePropertise(Environment environment) {
        this.environment = environment;
    }

    /**
     * プロパティーアクセスメソッド
     * @param name
     */
    public String getProperties(String name) {
        return environment.getProperty(name);
    }
}
