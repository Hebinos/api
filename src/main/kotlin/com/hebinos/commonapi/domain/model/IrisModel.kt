package com.hebinos.commonapi.domain.model

import com.hebinos.commonapi.infra.dto.analysis.IrisDTO

class IrisModel(
    val sepalLength: Double? = 0.0,
    val sepalWidth: Double? = 0.0,
    val petalLength: Double? = 0.0,
    val petalWidth: Double? = 0.0,
    val name: String = ""
)

fun IrisModel.convertFromDto(dto: IrisDTO): IrisModel {
    return IrisModel(
            sepalLength = dto.sepalLength.toDoubleOrNull(),
            sepalWidth = dto.sepalWidth.toDoubleOrNull(),
            petalLength = dto.petalLength.toDoubleOrNull(),
            petalWidth = dto.petalWidth.toDoubleOrNull(),
            name = dto.name)
}
