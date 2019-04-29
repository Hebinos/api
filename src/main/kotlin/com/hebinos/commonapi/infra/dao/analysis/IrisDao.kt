package com.hebinos.commonapi.infra.dao.analysis

import com.google.gson.Gson
import com.hebinos.commonapi.infra.dao.DaoInterface
import com.hebinos.commonapi.infra.dto.analysis.IrisDTO
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

const val SCHEMA_IRIS = "iris:"

@Component
class IrisDao : DaoInterface<IrisDTO> {

    override fun getSchema(): String {
        return SCHEMA_IRIS
    }

    override fun insertOneSet(idx: Int, redisTemplate: RedisTemplate<String, String>) {
        redisTemplate.opsForValue().set(SCHEMA_IRIS + idx, Gson().toJson(this, IrisDao::class.java))
    }

    override fun select(idx: Int, redisTemplate: RedisTemplate<String, String>): IrisDTO {
        val data = redisTemplate.opsForValue().get(SCHEMA_IRIS + idx)
        return Gson().fromJson(data, IrisDTO::class.java)
    }

    override fun convertFromCsvData(list: ArrayList<String>): IrisDTO {
        return IrisDTO(
                id = list[0],
                sepalWidth = list[2],
                petalLength = list[3],
                petalWidth = list[4],
                name = list[5]
        )
    }
}
