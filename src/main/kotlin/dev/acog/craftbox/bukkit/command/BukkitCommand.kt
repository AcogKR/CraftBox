package dev.acog.craftbox.bukkit.command

import dev.acog.craftbox.core.service.UserBoxService
import io.heartpattern.springfox.paper.command.annotation.CommandHandler
import io.heartpattern.springfox.paper.command.model.CommandInvocation
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import org.springframework.stereotype.Component

@Component
class BukkitCommand(
    private val userBoxService: UserBoxService,
    private val plugin: JavaPlugin
) {

    @CommandHandler(name = ["craftbox"])
    fun main(invocation: CommandInvocation) {
        val player = (invocation.sender as Player)
        val number = invocation.args.getOrNull(0)?.toIntOrNull() ?: 1
        val view = userBoxService.getUserBox(player.uniqueId, number)
        player.openInventory(view)
    }

}