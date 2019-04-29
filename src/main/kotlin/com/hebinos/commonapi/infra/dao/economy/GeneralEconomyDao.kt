package com.hebinos.commonapi.infra.dao.economy

import com.google.gson.Gson
import com.hebinos.commonapi.infra.dao.GeneralEconomyDTO
import com.hebinos.commonapi.infra.dao.DaoInterface
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

const val SCHEMA_ECONOOMYGENERAL = "economyGeneral:"

@Component
class GeneralEconomyDao : DaoInterface<GeneralEconomyDTO> {

        override fun getSchema(): String {
                return SCHEMA_ECONOOMYGENERAL
        }

        override fun insertOneSet(idx: Int, redisTemplate: RedisTemplate<String, String>) {
                redisTemplate.opsForValue().set(SCHEMA_ECONOOMYGENERAL + idx, Gson().toJson(this))
        }

        override fun select(idx: Int, redisTemplate: RedisTemplate<String, String>): GeneralEconomyDTO {
                val data = redisTemplate.opsForValue().get(SCHEMA_ECONOOMYGENERAL + idx)
                return Gson().fromJson(data, GeneralEconomyDTO::class.java)
        }

        override fun convertFromCsvData(list: ArrayList<String>): GeneralEconomyDTO {
                return GeneralEconomyDTO(
                        id = list[0],
                        name = list[1],
                        `class` = list[2],
                        organization_code = list[3],
                        organization = list[4],
                        field_code = list[5],
                        field = list[6],
                        architecture_code = list[7],
                        architecture = list[8],
                        reduction_code = list[9],
                        reduction = list[10],
                        pf_code = list[11],
                        pf = list[12],
                        year = list[13]
                )
        }
}
