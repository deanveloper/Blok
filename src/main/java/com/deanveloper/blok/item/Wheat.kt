package com.deanveloper.blok.item

import com.deanveloper.blok.block.Farmable
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.SeparatedData
import com.deanveloper.blok.util.toNybble

/**
 * Represents a wheat item and block
 *
 * @author Dean B
 */
class Wheat(
    override var growth: Farmable.Growth = Farmable.Growth.JUST_PLANTED
) : SeparatedData(59, 295), Farmable {
    override val id = "wheat"
    override val extraData: Nybble
        get() = growth.ordinal.toNybble()

    override fun clone() = Wheat(growth)

}
