package com.hebinos.commonapi.infra.dao

import org.springframework.data.redis.core.RedisTemplate

interface DaoInterface<D> {

    fun getSchema(): String

    fun insertOneSet(idx: Int, redisTemplate: RedisTemplate<String, String>)

    fun select(idx: Int, redisTemplate: RedisTemplate<String, String>): D

    fun convertFromCsvData(list: ArrayList<String>): D
}
