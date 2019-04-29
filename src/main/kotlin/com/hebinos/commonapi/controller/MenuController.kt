package com.hebinos.commonapi.controller

import com.hebinos.commonapi.controller.const.Const
import com.hebinos.commonapi.domain.service.shared.MenuService
import com.hebinos.commonapi.domain.service.shared.MenuModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MenuController @Autowired constructor(val menuService: MenuService) {

    @GetMapping("menu")
    fun menu(): ResponseEntity<List<MenuModel>> {
        return ResponseEntity(menuService.getDataList(), Const.getDefaultSuccessHeaders(), HttpStatus.OK)
    }
}
