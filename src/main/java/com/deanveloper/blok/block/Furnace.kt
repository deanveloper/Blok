package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Data
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

/**
 * Represents a furnace
 *
 * @author Dean B
 */
class Furnace(
    facing: Rotatable.Direction = Rotatable.Direction.NORTH,
    var lit: Boolean = false
) : BlockData, ItemData, Rotatable {

    override var facing by SidewaysRotatable(facing)

    override val id: String
        get() = if(lit) "lit_furnace" else "furnace"
    override val intId: Int
        get() = if(lit) 62 else 61
    override val extraData: Nybble
        get() = facing.direction.toNybble()

    override fun clone() = Furnace(facing, lit)

}
