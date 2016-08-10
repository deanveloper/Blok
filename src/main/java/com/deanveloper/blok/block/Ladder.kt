package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage
import com.deanveloper.blok.util.toNybble

/**
 * Represents a Ladder
 *
 * @author Dean B
 */
class Ladder(
        facing: SidewaysDirection = SidewaysDirection.NORTH
) : ItemData, BlockData, Rotatable<SidewaysDirection> {
    override val id = "ladder"
    override val intId = 65
    override var rawData = Nibble()

    override var facing: SidewaysDirection by NibbleStorage(0b1111, facing, { SidewaysDirection.values()[it] })

    override fun clone() = Ladder(facing)
}
