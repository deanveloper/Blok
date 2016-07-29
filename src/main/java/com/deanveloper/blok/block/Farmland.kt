package com.deanveloper.blok.block

import com.deanveloper.blok.util.Nibble

/**
 * Represents a farmland block
 *
 * @author Dean B
 */
class Farmland(var wetness: Byte = 0) : BlockData {
    override val id = "farmland"
    override val intId = 60
    override val rawData = Nibble(wetness)

    override fun clone() = Farmland(wetness)
}
