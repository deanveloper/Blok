package com.deanveloper.blok.item

import com.deanveloper.blok.block.Rotatable
import com.deanveloper.blok.block.SidewaysDirection
import com.deanveloper.blok.util.SeparatedData
import com.deanveloper.blok.util.Nybble

/**
 * Represents a bed item
 *
 * @author Dean B
 */
class Bed(
    override var facing: SidewaysDirection = SidewaysDirection.NORTH,
    var occupied: Boolean = false,
    var isHead: Boolean = false
) : SeparatedData(355, 26), Rotatable<SidewaysDirection> {
    override val id = "bed"

    override val extraData: Nybble
        get() {
            val data = Nybble()
            if (isItem) return data

            data[0b0011] = when (facing) {
                SidewaysDirection.SOUTH -> 0
                SidewaysDirection.WEST -> 1
                SidewaysDirection.NORTH -> 2
                SidewaysDirection.EAST -> 3
            }
            data[0b0100] = occupied
            data[0b1000] = isHead

            return data
        }

    override fun clone() = Bed(facing, occupied, isHead)
}
