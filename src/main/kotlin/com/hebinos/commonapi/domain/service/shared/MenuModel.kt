package com.hebinos.commonapi.domain.service.shared

import com.hebinos.commonapi.infra.dto.MenuDTO

class MenuModel(
    var id: Int = 0,
    var name: String = "",
    val link: String = ""
)

fun MenuModel.convertFromDto(dto: MenuDTO): MenuModel {
    return MenuModel(id = dto.id.toInt(), name = dto.name, link = dto.link)
}
