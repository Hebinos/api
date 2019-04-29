package com.hebinos.commonapi.infra.util

import com.hebinos.commonapi.infra.dao.analysis.IrisDao
import com.hebinos.commonapi.infra.dao.DaoInterface
import com.hebinos.commonapi.infra.dao.MenuDao
import java.io.BufferedReader
import java.io.FileReader
import java.util.regex.Pattern

class CsvToJson<D> {

    val pattern = Pattern.compile(",")

    fun readCsv(type: DataType): ArrayList<D> {
        val result = arrayListOf<D>()
        try {
            val br = BufferedReader(FileReader(type.filePath))
            br.lines().skip(1).map { line ->
                result.add(type.ins.convertFromCsvData(line.split(pattern) as ArrayList<String>) as D)
            }
        } catch (e: Exception) {
        }
        return result
    }
}

enum class DataType(val filePath: String, val ins: DaoInterface<*>) {
    MENU("setup/csv/menu.csv", MenuDao()),
//    ECONOMY("", GeneralEconomyDao()),
    IRIS("setup/csv/iris.csv", IrisDao())
}
