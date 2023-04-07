package dev.acog.craftbox.core.entity

import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*

@Entity(name = "userbox")
@EntityListeners(AuditingEntityListener::class)
data class UserBox(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(length = 25, nullable = false)
    var uuid: UUID,

    @Column(length = 100, nullable = false)
    var number: Int,

    @OneToMany(mappedBy = "", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    var items: MutableMap<Int, ByteArray>
) {
    constructor() : this(-1, UUID.randomUUID(), 0, mutableMapOf())
}