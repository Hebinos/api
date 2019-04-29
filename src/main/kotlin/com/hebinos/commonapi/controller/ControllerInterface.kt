package com.hebinos.commonapi.controller

interface ControllerInterface<M> {
    fun getWholeContents(): M
}