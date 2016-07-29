package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.toNybble

/**
 * Represents a chest
 *
 * @author Dean B
 */
class Chest(
        override var facing: SidewaysDirection = SidewaysDirection.NORTH
) : BlockData, ItemData, Rotatable<SidewaysDirection> {
    override val id = "chest"
    override val intId = 54
    override val rawData: Nibble
        get() = facing.asInt.toNybble()

    override fun clone() = Chest(facing)

}
