package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage

/**
 * @author Dean
 */
class RedstoneTorch(lit: Boolean = true, facing: Direction = Direction.UP) : BlockData, ItemData, BinaryPowerSource, Rotatable<Direction> {
    override val id = if(lit) "redstone_torch" else "unlit_redstone_torch"
    override val intId = if(lit) 76 else 75
    override var rawData = Nibble()

    override var powering: Boolean = lit

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

    override fun clone() = RedstoneTorch(powering, facing)
}