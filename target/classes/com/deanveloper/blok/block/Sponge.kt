package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.BOOLEAN_MAPPER
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage
import com.deanveloper.blok.util.toNybble

/**
 * Represents a sponge
 *
 * @author Dean B
 */
class Sponge(wet: Boolean = false) : ItemData, BlockData {
    override val id = "sponge"
    override val intId = 19
    override var rawData = Nibble()

    var wet: Boolean by NibbleStorage(0b0001, wet, BOOLEAN_MAPPER)

    override fun clone() = Sponge(wet)
}
