package dev.acog.craftbox.bukkit.command

import dev.acog.craftbox.core.entity.UserBox
import dev.acog.craftbox.core.service.UserBoxService
import io.heartpattern.springfox.paper.command.annotation.CommandHandler
import io.heartpattern.springfox.paper.command.annotation.TabCompleteHandler
import io.heartpattern.springfox.paper.command.model.CommandInvocation
import io.heartpattern.springfox.paper.command.model.TabCompletionInvocation
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import org.springframework.stereotype.Component

@Component
class BukkitCommand(
    private val userBoxService: UserBoxService,
    private val plugin: JavaPlugin
) {
    @CommandHandler(
        name = ["craftbox"]
    )
    fun main(invocation: CommandInvocation) {
        val player = (invocation.sender as Player) ?: return
        val command = invocation.args[0] ?: return
    }

    @TabCompleteHandler(
        name = "name"
    )
    fun mainTab(invocation: TabCompletionInvocation) {
    }
}