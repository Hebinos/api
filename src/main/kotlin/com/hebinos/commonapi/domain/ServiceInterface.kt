package com.hebinos.commonapi.domain

interface ServiceInterface<M, D> {
    fun getDataList(): List<M>
    fun convertList(dtoList: List<D>): List<M>
}