package com.deanveloper.blok.block

import com.deanveloper.blok.util.BYTE_MAPPER
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage

/**
 * Represents a farmland block
 *
 * @author Dean B
 */
class Farmland(wetness: Byte = 0) : BlockData {
    override val id = "farmland"
    override val intId = 60
    override var rawData = Nibble()

    var wetness: Byte by NibbleStorage(0b1111, wetness, BYTE_MAPPER)

    override fun clone() = Farmland(wetness)
}
