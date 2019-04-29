package com.hebinos.commonapi.infra.dao

import com.google.gson.Gson
import com.hebinos.commonapi.infra.dto.MenuDTO
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

const val SCHEMA_MENU = "menu:"

@Component
class MenuDao : DaoInterface<MenuDTO> {

        override fun getSchema(): String {
                return SCHEMA_MENU
        }

        override fun insertOneSet(idx: Int, redisTemplate: RedisTemplate<String, String>) {
                redisTemplate.opsForValue().set(SCHEMA_MENU + idx, Gson().toJson(this))
        }

        override fun select(idx: Int, redisTemplate: RedisTemplate<String, String>): MenuDTO {
                val data = redisTemplate.opsForValue().get(SCHEMA_MENU + idx)
                return Gson().fromJson(data, MenuDTO::class.java)
        }

        override fun convertFromCsvData(list: ArrayList<String>): MenuDTO {
                return MenuDTO(
                        id = list[0],
                        name = list[1],
                        link = list[2]
                )
        }
}
