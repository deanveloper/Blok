package com.deanveloper.blok.item

import com.deanveloper.blok.block.Farmable
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage
import com.deanveloper.blok.util.SeparatedData

/**
 * Represents a wheat item and block
 *
 * @author Dean B
 */
class Wheat(
        growth: Farmable.Growth = Farmable.Growth.JUST_PLANTED
) : SeparatedData(59, 295), Farmable {
    override val id = "wheat"
    override var rawData = Nibble()

    override var growth: Farmable.Growth by NibbleStorage(0b1111, growth) { Farmable.Growth.values()[it] }

    override fun clone() = Wheat(growth)

}
