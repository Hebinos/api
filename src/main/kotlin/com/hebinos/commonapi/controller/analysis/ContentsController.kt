package com.hebinos.commonapi.controller.analysis

import com.hebinos.commonapi.controller.ControllerInterface
import com.hebinos.commonapi.controller.const.Const
import com.hebinos.commonapi.domain.service.IrisService
import com.hebinos.commonapi.domain.model.IrisModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("analysis/")
class ContentsController @Autowired constructor(val irisService: IrisService) : ControllerInterface<ResponseEntity<List<IrisModel>>> {

    @GetMapping("iris")
    override fun getWholeContents(): ResponseEntity<List<IrisModel>> {
        return ResponseEntity(
                irisService.getDataList(),
                Const.getDefaultSuccessHeaders(),
                HttpStatus.OK)
    }
}