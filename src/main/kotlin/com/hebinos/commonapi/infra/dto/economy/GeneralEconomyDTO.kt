package com.hebinos.commonapi.infra.dao

import org.springframework.stereotype.Component

@Component
class GeneralEconomyDTO(
    var id: String = "",
    var name: String = "",
    var `class`: String = "",
    var organization_code: String = "",
    var organization: String = "",
    var field_code: String = "",
    var field: String = "",
    var architecture_code: String = "",
    var architecture: String = "",
    var reduction_code: String = "",
    var reduction: String = "",
    var pf_code: String = "",
    var pf: String = "",
    var year: String = ""
)
