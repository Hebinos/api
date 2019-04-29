package com.hebinos.commonapi.controller

import com.hebinos.commonapi.domain.service.shared.SetupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SetupController @Autowired constructor(val setupService: SetupService) {

    // TODO: For DEV
    @GetMapping("setup")
    @ResponseBody
    fun restore(): String {
        setupService.restoreData()
        return "restore完了♪"
    }
}
