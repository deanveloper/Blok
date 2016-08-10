package com.deanveloper.blok.item

import com.deanveloper.blok.block.Rotatable
import com.deanveloper.blok.block.SidewaysDirection
import com.deanveloper.blok.util.BOOLEAN_MAPPER
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage
import com.deanveloper.blok.util.SeparatedData

/**
 * Represents a bed item
 *
 * @author Dean B
 */
class Bed(
        facing: SidewaysDirection = SidewaysDirection.NORTH,
        occupied: Boolean = false,
        isHead: Boolean = false
) : SeparatedData(355, 26), Rotatable<SidewaysDirection> {
    override val id = "bed"
    override var rawData = Nibble()

    override var facing: SidewaysDirection by NibbleStorage(0b0011, facing) {
        when (it) {
            0 -> SidewaysDirection.SOUTH
            1 -> SidewaysDirection.WEST
            2 -> SidewaysDirection.NORTH
            3 -> SidewaysDirection.EAST
            else -> throw IllegalArgumentException()
        }
    }

    var occupied: Boolean by NibbleStorage(0b0100, occupied, BOOLEAN_MAPPER)

    var isHead: Boolean by NibbleStorage(0b1000, isHead, BOOLEAN_MAPPER)

    override fun clone() = Bed(facing, occupied, isHead)
}
