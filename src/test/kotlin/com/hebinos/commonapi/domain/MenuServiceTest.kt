package com.hebinos.commonapi.domain

import com.hebinos.commonapi.domain.service.shared.MenuService
import com.hebinos.commonapi.infra.RedisRepository
import com.hebinos.commonapi.infra.dao.MenuDao
import com.hebinos.commonapi.infra.dto.MenuDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class MenuServiceTest @Autowired constructor(var sut: MenuService) {

    @MockBean
    lateinit var mockRepo: RedisRepository<MenuDao>

    @Test
    fun getMenuList() {
        // arrange
        `when`(mockRepo.getAll<MenuDTO>(any())).thenReturn(
                listOf(
                        MenuDTO(id = "1", name = "a", link = "b"),
                        MenuDTO(id = "2", name = "c", link = "d")
                )
        )

        // act
        sut.getDataList()

        // assert
        verify(mockRepo).getAll<MenuDTO>(any())
    }
}
