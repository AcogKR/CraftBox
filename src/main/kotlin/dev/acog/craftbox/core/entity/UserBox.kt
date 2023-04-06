package dev.acog.craftbox.core.entity

import jakarta.persistence.CollectionTable
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import java.util.UUID

@Entity
data class UserBox(
    @Id
    @GeneratedValue
    val uuid: UUID,
    val id: Int,

    @ElementCollection
    @CollectionTable(name = "items", joinColumns = [JoinColumn(name = "item_id")])
    val items: Map<Int, ByteArray>
) {
    constructor() : this(UUID.randomUUID(), 0, emptyMap())
}