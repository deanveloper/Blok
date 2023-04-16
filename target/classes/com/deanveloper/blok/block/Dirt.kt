package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage
import com.deanveloper.blok.util.toNybble

class Dirt(dirtType: DirtType = Dirt.DirtType.NORMAL) : BlockData, ItemData {
    override val id = "dirt"
    override val intId = 3
    override var rawData = Nibble()

    override fun clone(): Dirt = Dirt(dirtType)

    var dirtType: DirtType by NibbleStorage(0b1111, dirtType, { DirtType.values()[it] })

    enum class DirtType {
        NORMAL,
        COARSE,
        PODZOL
    }
}
