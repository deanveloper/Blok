package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

/**
 * Represents a Wool block
 *
 * @author Dean B
 */
class Wool(
    override var color: Colorable.DyeColor = Colorable.DyeColor.WHITE
) : ItemData, BlockData, Colorable {
    override val id = "wool"
    override val intId = 35
    override val rawData: Nybble
        get() = color.ordinal.toNybble()

    override fun clone() = Wool(color)

}
