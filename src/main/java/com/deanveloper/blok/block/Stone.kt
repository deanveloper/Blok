package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage
import com.deanveloper.blok.util.toNybble

class Stone(type: StoneType = Stone.StoneType.NORMAL) : ItemData, BlockData {
    override val id = "stone"
    override val intId = 1
    override var rawData = Nibble()

    var type: StoneType by NibbleStorage(0b1111, type, { StoneType.values()[it] })

    override fun clone() = Stone(type)

    enum class StoneType {
        NORMAL,
        GRANITE,
        POLISHED_GRANITE,
        DIORITE,
        POLISHED_DIORITE,
        ANDESITE,
        POLISHED_ANDESITE
    }
}
