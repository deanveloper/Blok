package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.toNybble

/**
 * Represents a dispenser
 *
 * @author Dean B
 */
class Dispenser(
        override var facing: Direction = Direction.NORTH,
        var powered: Boolean = false
) : ItemData, BlockData, Rotatable<Direction> {
    override val id = "dispenser"
    override val intId = 23
    override val rawData: Nibble
        get() {
            val data = facing.asInt.toNybble()
            data[0b1000] = powered

            return data
        }

    override fun clone() = Dispenser(facing, powered)

}
