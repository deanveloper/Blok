package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

/**
 * Represents a lever
 *
 * @author Dean B
 */
class Lever(
    override var facing: Direction = Direction.DOWN,
    override var powering: Boolean = false
) : ItemData, BlockData, BinaryPowerSource, Rotatable<Direction> {
    override val id = "lever"
    override val intId = 69
    override val rawData: Nybble
        get() {
            val data = facing.asInt.toNybble()
            data[0b1000] = output

            return data
        }

    override fun clone() = Lever(facing, powering)
}
