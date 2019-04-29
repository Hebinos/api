package com.hebinos.commonapi.infra

import com.hebinos.commonapi.config.RedisDataConfig
import com.hebinos.commonapi.data.InitializeProcess
import com.hebinos.commonapi.infra.dao.analysis.IrisDao
import com.hebinos.commonapi.infra.dao.economy.GeneralEconomyDao
import com.hebinos.commonapi.infra.dao.DaoInterface
import com.hebinos.commonapi.infra.dao.MenuDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

@Repository
class RedisRepository<D> {

    lateinit var redisTemplate: RedisTemplate<String, String>

    init {
        val config = RedisDataConfig().redisConnectionFactory()
        redisTemplate = RedisDataConfig().redisTemplateUser(config)
        redisTemplate.afterPropertiesSet()
    }

    // TODO: For DEV
    fun restore() {
        deleteAll()

        var idx = 0
        // Menu
        val list1 = InitializeProcess().createMenuData()
        val menuDao = MenuDao()
        list1.forEach {
            menuDao.insertOneSet(idx, redisTemplate)
            idx++
        }

        // Iris
        val list2 = InitializeProcess().createIrisData()
        idx = 0
        val irisDao = IrisDao()
        list2.forEach {
            irisDao.insertOneSet(idx, redisTemplate)
            idx++
        }

        // GeneraEconomy
        // TODO
//        val list3 = InitializeProcess().createGeneralEconomyData()
//        idx = 0
//        val ecoDao = GeneralEconomyDao()
//        list3.forEach {
//            ecoDao.insertOneSet(idx, redisTemplate)
//            idx++
//        }
    }

    fun <T> getAll(dao: DaoInterface<D>): List<T> {
        val list = ArrayList<T>()
        val size = redisTemplate.keys("${dao.getSchema()}*").size
        for (idx in 0 until size - 1) list.add(dao.select(idx, redisTemplate) as T)
        return list
    }

    fun deleteAll() {
        redisTemplate.keys("*").forEach { redisTemplate.delete(it) }
    }
}
