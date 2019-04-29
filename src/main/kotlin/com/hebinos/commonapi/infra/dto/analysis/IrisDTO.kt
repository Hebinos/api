package com.hebinos.commonapi.infra.dto.analysis

import org.springframework.stereotype.Component

@Component
class IrisDTO(
    var id: String = "",
    var sepalLength: String = "",
    var sepalWidth: String = "",
    var petalLength: String = "",
    var petalWidth: String = "",
    var name: String = ""
)
