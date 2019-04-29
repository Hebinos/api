package com.hebinos.commonapi.domain.service.shared

import com.hebinos.commonapi.infra.RedisRepository
import com.hebinos.commonapi.infra.dto.MenuDTO
import org.springframework.stereotype.Service

@Service
class SetupService {

    fun restoreData() {
        RedisRepository<MenuDTO>().restore()
    }
}
