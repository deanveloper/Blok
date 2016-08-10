package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage
import com.deanveloper.blok.util.toNybble

/**
 * Represents a Wool block
 *
 * @author Dean B
 */
class Wool(
        color: Colorable.DyeColor = Colorable.DyeColor.WHITE
) : ItemData, BlockData, Colorable {
    override val id = "wool"
    override val intId = 35
    override var rawData = Nibble()

    override var color: Colorable.DyeColor by NibbleStorage(0b1111, color, { Colorable.DyeColor.values()[it] })
    override fun clone() = Wool(color)

}
