package com.ww.fast.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

@Configuration
public class Jackson2JsonConfig {

    private final static Logger log = LoggerFactory.getLogger(Jackson2JsonConfig.class);


    @Bean
    public GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer() {
        log.info("*************************genericJackson2JsonRedisSerializer注入完成****************************");
        return new GenericJackson2JsonRedisSerializer();
    }
}
