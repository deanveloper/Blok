package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Data
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

/**
 * Represents a chest
 *
 * @author Dean B
 */
class Chest(
    facing: Rotatable.Direction = Rotatable.Direction.NORTH
) : BlockData, ItemData, Rotatable {
    override val id = "chest"
    override val intId = 54
    override var facing: Rotatable.Direction by SidewaysRotatable(facing)
    override val extraData: Nybble
        get() = facing.direction.toNybble()

    override fun clone() = Chest(facing)

}
