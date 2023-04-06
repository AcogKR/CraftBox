package dev.acog.craftbox

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.bukkit.plugin.java.JavaPlugin
import org.springframework.stereotype.Service

@Service
class CraftBoxService(
    private val plugin: JavaPlugin
) {

    @PostConstruct
    fun start() {
        plugin.getLogger().info("fuck You")
    }

    @PreDestroy
    fun stop() {
        plugin.getLogger().info("h")
    }

}
