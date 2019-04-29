package com.hebinos.commonapi.controller

import com.google.gson.Gson
import com.hebinos.commonapi.domain.service.shared.MenuService
import com.hebinos.commonapi.domain.service.shared.MenuModel
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@WebMvcTest
class MenuControllerTest {

    @MockBean
    lateinit var menuService: MenuService

    @Autowired
    lateinit var mockMvc: MockMvc

    private val gson = Gson()

    @Test
    fun メニュー1が見えること() {
        // arrange
        `when`(menuService.getDataList()).thenReturn(
                listOf(
                        MenuModel(id = 1, name = "あいうえお", link = "リンク")
                )
        )
        val expect = listOf(
                MenuModel(id = 1, name = "あいうえお", link = "リンク")
        )

        // act, assert
        mockMvc.perform(get("/menu"))
                .andExpect(status().`is`(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(gson.toJson(expect)))
    }
}
