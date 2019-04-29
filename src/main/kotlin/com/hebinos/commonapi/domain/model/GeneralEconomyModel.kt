package com.hebinos.commonapi.domain.model

import com.hebinos.commonapi.infra.dao.GeneralEconomyDTO
import org.springframework.stereotype.Component

@Component
class GeneralEconomyModel(
    val id: Int = 0,
    val name: String = "",
    val code_name: String = "",
    val `class`: String = "",
    val organization_code: Int? = 0,
    val organization: String = "",
    val field_code: Int? = 0,
    val field: String = "",
    val architecture_code: Int? = 0,
    val architecture: String = "",
    val reduction_code: Int? = 0,
    val reduction: String = "",
    val pf_code: Int? = 0,
    val pf: String = "",
    val year: String = ""
)

fun GeneralEconomyModel.convertFromDto(dto: GeneralEconomyDTO): GeneralEconomyModel {
    return GeneralEconomyModel(
            id = dto.id.toInt(),
            name = dto.name,
            `class` = dto.`class`,
            organization_code = dto.organization_code.toIntOrNull(),
            organization = dto.organization,
            field_code = dto.field_code.toIntOrNull(),
            field = dto.field,
            architecture_code = dto.architecture_code.toIntOrNull(),
            architecture = dto.architecture,
            reduction_code = dto.reduction_code.toIntOrNull(),
            reduction = dto.reduction,
            pf_code = dto.pf_code.toIntOrNull(),
            pf = dto.pf,
            year = dto.year
    )
}
