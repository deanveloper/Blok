package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nibble

/**
 * @author Dean B
 */
class Tnt(var explodes: Boolean = false) : ItemData, BlockData {
    override val id = "tnt"
    override val intId = 46
    override val rawData: Nibble
        get() = Nibble().apply { this[0b0001] = explodes }

    override fun clone() = Tnt(explodes)
}
