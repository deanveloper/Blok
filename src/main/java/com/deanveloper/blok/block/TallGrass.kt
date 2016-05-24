package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

/**
 * @author Dean B
 */
class TallGrass(
    var type: GrassType = TallGrass.GrassType.SHRUB
) : ItemData, BlockData {
    override val id = "tallgrass"
    override val intId = 31
    override val extraData: Nybble
        get() = type.ordinal.toNybble()

    override fun clone() = TallGrass(type)

    enum class GrassType {
        SHRUB,
        TALL_GRASS,
        FERN
    }
}
