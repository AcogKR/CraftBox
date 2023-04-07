package dev.acog.craftbox.core.service

import dev.acog.craftbox.core.entity.UserBox
import dev.acog.craftbox.core.repository.UserBoxRepository
import io.typecraft.bukkit.view.ChestView
import io.typecraft.bukkit.view.ViewContents
import jakarta.transaction.Transactional
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.springframework.stereotype.Service
import java.util.UUID

@Service
open class UserBoxService(
    private val userBoxRepository: UserBoxRepository
) {

    fun saveUserBox(userBox: UserBox) {
        userBoxRepository.save(userBox)
    }

    @Transactional
    open fun getUserBox(uuid: UUID, number: Int) : Inventory {
        val userBox = userBoxRepository.findAll()

        userBox.forEach { box ->
            box.items.forEach { items ->
                println(items.int)
            }
        }
//        val box = userBox.getOrNull(number) ?: run {
//            val newUserBox = UserBox(UUID.randomUUID(), 0, mutableMapOf())
//            userBoxRepository.save(newUserBox)
//            newUserBox
//        }

        return Bukkit.createInventory(null, 6 * 9, Component.text("$number : 보관함")).apply {
//            box.items.forEach { (key, value) ->
//                this.setItem(key, ItemStack.deserializeBytes(value))
//            }
        }
    }

}