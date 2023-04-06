package dev.acog.craftbox.core.repository

import dev.acog.craftbox.core.entity.UserBox
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserBoxRepository : JpaRepository<UserBox, UUID>