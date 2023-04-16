package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.BOOLEAN_MAPPER
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage
import com.deanveloper.blok.util.toNybble

/**
 * Describes a sand block
 *
 * @author Dean B
 */
class Sand(red: Boolean = false) : BlockData, ItemData {
    override val id = "sand"
    override val intId = 12
    override var rawData = Nibble()

    var red: Boolean by NibbleStorage(0b0001, red, BOOLEAN_MAPPER)

    override fun clone() = Sand(red)

}
