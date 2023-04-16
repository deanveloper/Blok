package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage
import com.deanveloper.blok.util.toNybble

/**
 * Represents a chest
 *
 * @author Dean B
 */
class Chest(
        facing: SidewaysDirection = SidewaysDirection.NORTH
) : BlockData, ItemData, Rotatable<SidewaysDirection> {
    override val id = "chest"
    override val intId = 54
    override var rawData = Nibble()

    override var facing: SidewaysDirection by NibbleStorage(0b1111, facing, { SidewaysDirection.fromInt(it) })

    override fun clone() = Chest(facing)

}
