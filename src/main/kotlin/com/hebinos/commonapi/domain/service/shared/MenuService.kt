package com.hebinos.commonapi.domain.service.shared

import com.hebinos.commonapi.domain.ServiceInterface
import com.hebinos.commonapi.infra.RedisRepository
import com.hebinos.commonapi.infra.dao.DaoInterface
import com.hebinos.commonapi.infra.dao.MenuDao
import com.hebinos.commonapi.infra.dto.MenuDTO
import org.springframework.stereotype.Service

@Service
class MenuService : ServiceInterface<MenuModel, MenuDTO> {

    override fun getDataList(): List<MenuModel> {
        val storedList = RedisRepository<MenuDao>().getAll<MenuDTO>(MenuDao() as DaoInterface<MenuDao>)
        return convertList(storedList)
    }

    override fun convertList(dtoList: List<MenuDTO>): List<MenuModel> {
        val list = ArrayList<MenuModel>()
        dtoList.forEach { dto ->
            list.add(MenuModel().convertFromDto(dto))
        }
        return list
    }
}
