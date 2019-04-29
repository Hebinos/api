package com.hebinos.commonapi.controller.const

import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

class Const {

    companion object {
        fun getDefaultSuccessHeaders(): HttpHeaders {
            val headers = HttpHeaders()
            headers.contentType = MediaType.APPLICATION_JSON_UTF8
            return headers
        }
    }
}