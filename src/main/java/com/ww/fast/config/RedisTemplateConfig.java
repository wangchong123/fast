package com.ww.fast.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisTemplateConfig {

    private final static Logger log = LoggerFactory.getLogger(RedisTemplateConfig.class);

    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        template.setKeySerializer(StringRedisSerializer.UTF_8);
        template.setValueSerializer(genericJackson2JsonRedisSerializer);
        template.setHashKeySerializer(StringRedisSerializer.UTF_8);
        template.setHashValueSerializer(genericJackson2JsonRedisSerializer);
        template.setEnableTransactionSupport(true);
        template.setConnectionFactory(redisConnectionFactory);
        template.afterPropertiesSet();
        log.info("*************************redisTemplate<String, Object>注入完成****************************");
        return template;
    }
}
