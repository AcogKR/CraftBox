package dev.acog.craftbox.bukkit.listener

import dev.acog.craftbox.core.entity.UserBox
import dev.acog.craftbox.core.service.UserBoxService
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.inventory.InventoryCloseEvent
import org.springframework.stereotype.Component

@Component
class BukkitListener(
    private val userBoxService: UserBoxService
) {

    @EventHandler
    fun onClose(e: InventoryCloseEvent) {
        val title = e.view.title
        if (!title.contains("보관함")) {
            return
        }

        val number = title.substringBefore(" : ").toIntOrNull() ?: return
        val items = e.view.topInventory.contents
            .withIndex()
            .filter { (_, item) -> item != null && item.type != Material.AIR }
            .map { (index, item) -> Item(e .player.uniqueId, index, UserBox(), item!!.serializeAsBytes()) }
            .toMutableList()
        userBoxService.saveUserBox(UserBox(e.player.uniqueId, number, items))
        e.player.sendMessage("$number 페이지의 보관함 아이템이 저장되었습니다.")
    }

}