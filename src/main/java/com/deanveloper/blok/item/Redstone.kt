package com.deanveloper.blok.item

import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.SeparatedData
import com.deanveloper.blok.util.toNybble

/**
 * @author Dean B
 */
class Redstone(var power: Int = 0) : SeparatedData(331, 55) {
    override val id: String
        get() = if (isItem) "redstone" else "redstone_wire"
    override val extraData: Nybble
        get() = if (isBlock) power.toNybble() else 0.toNybble()

    override fun clone() = Redstone(power)

}
