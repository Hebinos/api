package com.hebinos.commonapi.data

import com.hebinos.commonapi.infra.dto.MenuDTO
import com.hebinos.commonapi.infra.dto.analysis.IrisDTO
import com.hebinos.commonapi.infra.util.CsvToJson
import com.hebinos.commonapi.infra.util.DataType

class InitializeProcess {

    fun createMenuData(): List<MenuDTO> {
        return CsvToJson<MenuDTO>().readCsv(DataType.MENU)
    }

    // TOOD
//    fun createGeneralEconomyData(): List<GeneralEconomyDTO> {
//        return CsvToJson<GeneralEconomyDTO>().readCsv(DataType.ECONOMY)
//    }

    fun createIrisData(): List<IrisDTO> {
        return CsvToJson<IrisDTO>().readCsv(DataType.IRIS)
    }
}
