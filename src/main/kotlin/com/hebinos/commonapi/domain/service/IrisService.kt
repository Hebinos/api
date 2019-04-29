package com.hebinos.commonapi.domain.service

import com.hebinos.commonapi.domain.ServiceInterface
import com.hebinos.commonapi.domain.model.IrisModel
import com.hebinos.commonapi.domain.model.convertFromDto
import com.hebinos.commonapi.infra.RedisRepository
import com.hebinos.commonapi.infra.dao.analysis.IrisDao
import com.hebinos.commonapi.infra.dto.analysis.IrisDTO
import org.springframework.stereotype.Service

@Service
class
IrisService : ServiceInterface<IrisModel, IrisDTO> {

    override fun getDataList(): List<IrisModel> {
        val storedList = RedisRepository<IrisDTO>().getAll<IrisDTO>(IrisDao())
        val result = ArrayList<IrisModel>()
        storedList.forEach { dto ->
            result.add(IrisModel().convertFromDto(dto))
        }
        return convertList(storedList)
    }

    override fun convertList(dtoList: List<IrisDTO>): List<IrisModel> {
        val list = ArrayList<IrisModel>()
        dtoList.forEach { dto ->
            list.add(IrisModel().convertFromDto(dto))
        }
        return list
    }
}
