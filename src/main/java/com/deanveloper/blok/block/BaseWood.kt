package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.toNybble


sealed class BaseWood(var type: WoodType) : ItemData, BlockData {
    class Planks(type: WoodType = WoodType.OAK) : BaseWood(type) {
        override fun clone() = Planks(type)

        override val id = "planks"
        override val intId = 5
        override val rawData: Nibble
            get() = type.ordinal.toNybble()
    }

    class Sapling(
            type: WoodType = WoodType.OAK,
            var ready: Boolean = false
    ) : BaseWood(type) {
        override fun clone() = Planks(type)

        override val id = "sapling"
        override val intId = 5
        override val rawData: Nibble
            get() {
                val data = type.ordinal.toNybble()
                data[0b1000] = ready

                return data
            }
    }

    sealed class BaseDoubleWood(
            type: WoodType,
            val id1: String,
            val id2: String,
            val intId1: Int,
            val intId2: Int
    ) : BaseWood(type) {

        //region Variables/Values
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
        //endregion

        class Log(
                type: WoodType = WoodType.OAK,
                override var facing: BiDirection = BiDirection.NORTH_SOUTH
        ) : BaseDoubleWood(type, "log", "log2", 17, 162), Rotatable<BiDirection> {
            override fun clone() = Log(type)

            override val rawData: Nibble
                get() {
                    val data = (if (isFirstType) type.ordinal else type.ordinal - 4).toNybble()

                    data[0b1100] = facing.asInt

                    return data
                }
        }

        class Leaves(
                type: WoodType = WoodType.OAK,
                var noDecay: Boolean = false,
                var checkDecay: Boolean = true
        ) : BaseDoubleWood(type, "leaves", "leaves2", 17, 162) {
            override val rawData: Nibble
                get() {
                    val data = (if (isFirstType) type.ordinal else type.ordinal - 4).toNybble()
                    data[0b0100] = noDecay
                    data[0b1000] = checkDecay

                    return data
                }

            override fun clone() = Leaves(type, noDecay, checkDecay);
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
