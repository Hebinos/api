package com.hebinos.commonapi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer
import kotlin.text.Charsets.UTF_8

@Configuration
class RedisDataConfig {

    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory {
        val factory = JedisConnectionFactory()
        factory.setHostName("localhost")
        factory.setPort(6379)
        return factory
    }

    @Bean("redisUserTemplate")
    fun redisTemplateUser(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<String, String> {
        val template = RedisTemplate<String, String>()
        template.setConnectionFactory(redisConnectionFactory)
        template.setDefaultSerializer(GenericJackson2JsonRedisSerializer())
        template.setDefaultSerializer(GenericJackson2JsonRedisSerializer())
        template.keySerializer = StringRedisSerializer(UTF_8)
        template.hashKeySerializer = GenericJackson2JsonRedisSerializer()
        template.valueSerializer = GenericJackson2JsonRedisSerializer()
        template.afterPropertiesSet()
        return template
    }
}