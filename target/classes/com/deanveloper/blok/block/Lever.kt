package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.BOOLEAN_MAPPER
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage
import com.deanveloper.blok.util.toNybble

/**
 * Represents a lever
 *
 * @author Dean B
 */
class Lever(
        facing: Direction = Direction.DOWN,
        powering: Boolean = false
) : ItemData, BlockData, BinaryPowerSource, Rotatable<Direction> {
    override val id = "lever"
    override val intId = 69
    override var rawData = Nibble()

    override var facing: Direction by NibbleStorage(0b0111, facing, { Direction.values()[it] })
    override var powering: Boolean by NibbleStorage(0b1000, powering, BOOLEAN_MAPPER)
    override fun clone() = Lever(facing, powering)
}
