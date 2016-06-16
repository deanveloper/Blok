package com.deanveloper.blok.item

import com.deanveloper.blok.block.Farmable
import com.deanveloper.blok.util.NybbleStorage
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.SeparatedData
import com.deanveloper.blok.util.toNybble

/**
 * Represents a wheat item and block
 *
 * @author Dean B
 */
class Wheat(
    growth: Farmable.Growth = Farmable.Growth.JUST_PLANTED
) : SeparatedData(59, 295), Farmable {
    override val id = "wheat"
    override var rawData = Nybble()

    override var growth: Farmable.Growth by NybbleStorage(0b1111, growth) { Farmable.Growth.values()[it] }

    override fun clone() = Wheat(growth)

}
