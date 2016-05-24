package com.deanveloper.blok.entity.living

import com.deanveloper.blok.placeholders.HumanInventory
import com.deanveloper.blok.placeholders.Inventory
import com.deanveloper.blok.placeholders.Item
import java.time.LocalDateTime

/**
 * @author Dean B
 */
interface Human : LivingEntity {
    /**
     * Their open inventory (null if none)
     */
    var openInventory: Inventory?

    /**
     * Their ender chest
     */
    var enderChest: Inventory

    /**
     * Their gamemode
     */
    var gameMode: GameMode

    /**
     * Their inventory
     */
    var inventory: HumanInventory

    /**
     * If they're left handed
     */
    var leftHanded: Boolean

    /**
     * The item in one of their hands
     */
    fun itemInHand(hand: Hand): Item

    /**
     * The time they've been sleeping since
     */
    var sleepingSince: LocalDateTime?

    /**
     * If they are sleeping
     */
    var sleeping: Boolean

    /**
     * If they are blocking (with a shield)
     */
    var isBlocking: Boolean

    /**
     * An enum that represents the gamemodes, in order of their integer representation
     */
    enum class GameMode {
        SURVIVAL,
        CREATIVE,
        ADVENTURE,
        SPECTATOR
    }
}

