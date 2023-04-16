package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage
import com.deanveloper.blok.util.toNybble

/**
 * Represents a furnace
 *
 * @author Dean B
 */
class Furnace(
        facing: SidewaysDirection = SidewaysDirection.NORTH,
        var lit: Boolean = false
) : BlockData, ItemData, Rotatable<SidewaysDirection> {

    override val id: String
        get() = if (lit) "lit_furnace" else "furnace"
    override val intId: Int
        get() = if (lit) 62 else 61
    override var rawData = Nibble()

    override var facing: SidewaysDirection by NibbleStorage(0b1111, facing, { SidewaysDirection.values()[it] })

    override fun clone() = Furnace(facing, lit)

}
