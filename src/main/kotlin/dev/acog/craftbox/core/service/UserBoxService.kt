package dev.acog.craftbox.core.service

import dev.acog.craftbox.core.entity.UserBox
import dev.acog.craftbox.core.repository.UserBoxRepository
import org.springframework.stereotype.Service

@Service
class UserBoxService(
    private val userBoxRepository: UserBoxRepository
) {

    fun saveUserBox(userBox: UserBox) {
        userBoxRepository.save(userBox)
    }

}