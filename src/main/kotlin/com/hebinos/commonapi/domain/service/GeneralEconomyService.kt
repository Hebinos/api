package com.hebinos.commonapi.domain.service

import com.hebinos.commonapi.domain.ServiceInterface
import com.hebinos.commonapi.domain.model.GeneralEconomyModel
import com.hebinos.commonapi.domain.model.convertFromDto
import com.hebinos.commonapi.infra.RedisRepository
import com.hebinos.commonapi.infra.dao.GeneralEconomyDTO
import com.hebinos.commonapi.infra.dao.economy.GeneralEconomyDao
import org.springframework.stereotype.Service

@Service
class GeneralEconomyService : ServiceInterface<GeneralEconomyModel, GeneralEconomyDTO> {

    override fun getDataList(): List<GeneralEconomyModel> {
        val storedList = RedisRepository<GeneralEconomyDTO>().getAll<GeneralEconomyDTO>(GeneralEconomyDao())
        return convertList(storedList as ArrayList<GeneralEconomyDTO>)
    }

    override fun convertList(dtoList: List<GeneralEconomyDTO>): List<GeneralEconomyModel> {
        val list = ArrayList<GeneralEconomyModel>()
        dtoList.forEach { dto ->
            list.add(GeneralEconomyModel().convertFromDto(dto))
        }
        return list
    }
}
