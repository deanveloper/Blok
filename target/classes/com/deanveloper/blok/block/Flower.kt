package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage

class Flower(type: FlowerType = FlowerType.POPPY) : ItemData, BlockData {
    override val id = "red_flower"
    override val intId = 38
    override var rawData = Nibble()

    override fun clone() = Flower(type)

    var type: FlowerType by NibbleStorage(0b1111, type, { FlowerType.values()[it] })

    enum class FlowerType {
        POPPY,
        BLUE_ORCHID,
        ALLIUM,
        AZURE_BLUET,
        RED_TULIP,
        ORANGE_TULIP,
        WHITE_TULIP,
        PINK_TULIP,
        OXEYE_DAISY
    }
}
