package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.toNybble

/**
 * Represents a Ladder
 *
 * @author Dean B
 */
class Ladder(
        override var facing: SidewaysDirection = SidewaysDirection.NORTH
) : ItemData, BlockData, Rotatable<SidewaysDirection> {
    override val id = "ladder"
    override val intId = 65
    override val rawData: Nibble
        get() = facing.asInt.toNybble()

    override fun clone() = Ladder(facing)
}
