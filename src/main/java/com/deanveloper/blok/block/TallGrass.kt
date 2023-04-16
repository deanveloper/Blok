package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage
import com.deanveloper.blok.util.toNybble

/**
 * @author Dean B
 */
class TallGrass(
        type: GrassType = TallGrass.GrassType.SHRUB
) : ItemData, BlockData {
    override val id = "tallgrass"
    override val intId = 31
    override var rawData = Nibble()

    var type: GrassType by NibbleStorage(0b1111, type, { GrassType.values()[it] })

    override fun clone() = TallGrass(type)

    enum class GrassType {
        SHRUB,
        TALL_GRASS,
        FERN
    }
}
