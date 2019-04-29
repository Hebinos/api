package com.hebinos.commonapi.infra.dto

import org.springframework.stereotype.Component

@Component
class MenuDTO(
    var id: String = "",
    var name: String = "",
    var link: String = ""
)
