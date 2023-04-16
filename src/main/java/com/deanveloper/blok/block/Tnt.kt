package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.BOOLEAN_MAPPER
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage

/**
 * @author Dean B
 */
class Tnt(unstable: Boolean = false) : ItemData, BlockData {
    override val id = "tnt"
    override val intId = 46
    override var rawData = Nibble()

    var unstable: Boolean by NibbleStorage(0b0001, unstable, BOOLEAN_MAPPER)

    override fun clone() = Tnt(unstable)
}
