package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.BOOLEAN_MAPPER
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage
import com.deanveloper.blok.util.toNybble


sealed class BaseWood(type: WoodType) : ItemData, BlockData {
    abstract var type: WoodType

    class Planks(type: WoodType = WoodType.OAK) : BaseWood(type) {
        override fun clone() = Planks(type)

        override val id = "planks"
        override val intId = 5
        override var rawData = Nibble()

        override var type: WoodType by NibbleStorage(0b1111, type, { WoodType.values()[it] })
    }

    class Sapling(
            type: WoodType = WoodType.OAK,
            ready: Boolean = false
    ) : BaseWood(type) {

        override fun clone() = Planks(type)

        override val id = "sapling"
        override val intId = 5
        override var rawData = Nibble()

        override var type: WoodType by NibbleStorage(0b0111, type, { WoodType.values()[it] })
        var ready: Boolean by NibbleStorage(0b1000, ready, BOOLEAN_MAPPER)
    }

    sealed class BaseDoubleWood(
            type: WoodType,
            val id1: String,
            val id2: String,
            val intId1: Int,
            val intId2: Int
    ) : BaseWood(type) {

        val DOUBLE_WOOD_MAPPER = { it: Int -> if (isFirstType) WoodType.values()[it] else WoodType.values()[it - 4] }

        val isFirstType: Boolean
            get() = when (type) {
                WoodType.OAK, WoodType.SPRUCE,
                WoodType.BIRCH, WoodType.JUNGLE -> true

                else -> false
            }

        final override val id: String
            get() = if (isFirstType) id1 else id2

        final override val intId: Int
            get() = if (isFirstType) intId1 else intId2

        class Log(
                type: WoodType = WoodType.OAK,
                facing: BiDirection = BiDirection.NORTH_SOUTH
        ) : BaseDoubleWood(type, "log", "log2", 17, 162), Rotatable<BiDirection> {
            override fun clone() = Log(type)

            override var rawData = Nibble()

            override var type: WoodType by NibbleStorage(0b0011, type, DOUBLE_WOOD_MAPPER)

            override var facing: BiDirection by NibbleStorage(0b1100, facing, { BiDirection.values()[it] })
        }

        class Leaves(
                type: WoodType = WoodType.OAK,
                noDecay: Boolean = false,
                checkDecay: Boolean = true
        ) : BaseDoubleWood(type, "leaves", "leaves2", 17, 162) {
            override var rawData = Nibble()

            override var type: WoodType by NibbleStorage(0b0011, type, DOUBLE_WOOD_MAPPER)

            var noDecay: Boolean by NibbleStorage(0b0100, noDecay, BOOLEAN_MAPPER)

            var checkDecay: Boolean by NibbleStorage(0b1000, checkDecay, BOOLEAN_MAPPER)

            override fun clone() = Leaves(type, noDecay, checkDecay)
        }
    }

    enum class WoodType {
        OAK,
        SPRUCE,
        BIRCH,
        JUNGLE,
        ACACIA,
        DARK_OAK
    }
}
