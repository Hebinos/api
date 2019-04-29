package com.hebinos.commonapi.controller.economy

import com.hebinos.commonapi.controller.ControllerInterface
import com.hebinos.commonapi.controller.const.Const
import com.hebinos.commonapi.domain.model.GeneralEconomyModel
import com.hebinos.commonapi.domain.service.GeneralEconomyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("economy/")
class GeneralController @Autowired constructor(val service: GeneralEconomyService) : ControllerInterface<ResponseEntity<List<GeneralEconomyModel>>> {

    @GetMapping("whole")
    override fun getWholeContents(): ResponseEntity<List<GeneralEconomyModel>> {
        return ResponseEntity(
                service.getDataList(),
                Const.getDefaultSuccessHeaders(),
                HttpStatus.OK)
    }
}