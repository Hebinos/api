package com.hebinos.commonapi.infra

import com.hebinos.commonapi.infra.dao.DaoInterface
import com.hebinos.commonapi.infra.dao.MenuDao
import com.hebinos.commonapi.infra.dto.MenuDTO
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class MenuRepositoryTest @Autowired constructor(var sut: RedisRepository<MenuDao>){



    @Test
    fun test_getAll() {
        // TODO* ユーティリティで
        // arrange
        sut.restore()

        // act
        val actual = sut.getAll<MenuDTO>(MenuDao() as DaoInterface<MenuDao>)
        val expect = createTestData()

        // assert
        assertEquals(expect, actual)
    }

    private fun createTestData(): List<MenuDTO> {
        val list = ArrayList<MenuDTO>()
        for (i in 1..1000) {
            list.add(MenuDTO(id = "i", name = "テストname$i", link = "テストlink$i"))
        }
        return list
    }

    @Before
    fun setUp() {
        // TODO: ユーティリティで
        sut.deleteAll()
    }

    @After
    fun tearDown() {
        // TODO: ユーティリティで
        sut.deleteAll()
    }
}
