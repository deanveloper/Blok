package com.deanveloper.blok.block

import com.deanveloper.blok.util.Data
import com.deanveloper.blok.util.Nybble

/**
 * Represents a farmland block
 *
 * @author Dean B
 */
class Farmland(var wetness: Byte = 0) : BlockData {
    override val id = "farmland"
    override val intId = 60
    override val extraData = Nybble(wetness)

    override fun clone() = Farmland(wetness)
}
