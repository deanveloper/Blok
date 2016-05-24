package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Data
import com.deanveloper.blok.util.Nybble
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
    override val extraData: Nybble
        get() = facing.asInt.toNybble()

    override fun clone() = Ladder(facing)
}
