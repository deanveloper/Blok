package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage

/**
 * @author Dean B
 */
class Torch(
        facing: Direction = Direction.UP
) : ItemData, BlockData, Rotatable<Direction> {
    override val id = "torch"
    override val intId = 50

    private var _facing: Direction by NibbleStorage(0b1111, facing, { Direction.values()[6 - it] })
    override var facing: Direction
        get() = _facing
        set(value) {
            if (value == Direction.DOWN) {
                _facing = Direction.UP
            } else {
                _facing = value
            }
        }


    override var rawData = Nibble()

    override fun clone() = Torch(facing)

}
