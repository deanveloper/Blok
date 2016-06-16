package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

/**
 * @author Dean B
 */
class Torch(
    facing: Direction = Direction.UP
) : ItemData, BlockData, Rotatable<Direction> {
    override val id = "torch"
    override val intId = 50

    override var facing = facing
        set(value) {
            if (value == Direction.DOWN) field = Direction.UP
            field = value
        }

    override val rawData: Nybble
        get() = (6 - facing.asInt).toNybble()

    override fun clone() = Torch(facing)

}
