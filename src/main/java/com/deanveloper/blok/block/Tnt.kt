package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nybble

/**
 * @author Dean B
 */
class Tnt(var explodes: Boolean = false) : ItemData, BlockData {
    override val id = "tnt"
    override val intId = 46
    override val rawData: Nybble
        get() = Nybble().apply { this[0b0001] = explodes }

    override fun clone() = Tnt(explodes)
}
