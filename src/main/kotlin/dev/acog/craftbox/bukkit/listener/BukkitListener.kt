package dev.acog.craftbox.bukkit.listener

import dev.acog.craftbox.core.service.UserBoxService
import org.springframework.beans.factory.annotation.Autowired

class BukkitListener(
    @Autowired
    private val userBoxService: UserBoxService
) {
}