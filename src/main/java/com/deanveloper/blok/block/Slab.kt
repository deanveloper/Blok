package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Data
import com.deanveloper.blok.util.Nybble

/**
 * @author Dean B
 */
class Slab(
    var volume: Volume = Slab.Volume.TOP,
    var type: SlabType = Slab.SlabType.STONE
) : BlockData, ItemData {
    override val id: String
        get() {
            //special case
            if (type == SlabType.PURPUR && (volume == Volume.ALL || volume == Volume.SMOOTH_ALL)) {
                return "purpur_double_slab"
            } else {
                return buildString {
                    if (volume == Volume.ALL || volume == Volume.SMOOTH_ALL) append("double_")
                    append(type.id)
                }
            }
        }

    override val intId: Int
        get() = when (id) {
            "double_stone_slab" -> 43
            "stone_slab" -> 44
            "double_wooden_slab" -> 125
            "wooden_slab" -> 126
            "double_stone_slab2" -> 181
            "stone_slab2" -> 182
            "purpur_double_slab" -> 204
            "purpur_slab" -> 205
            else -> throw IllegalStateException("String id is not valid! ($id)")
        }

    override val rawData: Nybble
        get() {
            var data = Nybble()
            data[0b0111] = type.data
            data[0b1000] = volume == Volume.TOP || volume == Volume.SMOOTH_ALL

            return data
        }

    override fun clone(): Data {
        throw UnsupportedOperationException()
    }

    enum class SlabType(val id: String, val data: Int) {
        STONE("stone_slab", 0),
        SANDSTONE("stone_slab", 1),
        @Deprecated("Not used") WOOD_OLD("stone_slab", 2),
        COBBLESTONE("stone_slab", 3),
        BRICKS("stone_slab", 4),
        STONE_BRICK("stone_slab", 5),
        NETHER_BRICK("stone_slab", 6),
        QUARTZ("stone_slab", 7),
        RED_SANDSTONE("stone_slab2", 0),
        PURPUR("purpur_slab", 0),
        OAK_WOOD("wooden_slab", 0),
        SPRUCE_WOOD("wooden_slab", 1),
        BIRCH_WOOD("wooden_slab", 2),
        JUNGLE_WOOD("wooden_slab", 3),
        ACACIA_WOOD("wooden_slab", 4),
        DARK_OAK_WOOD("wooden_slab", 5);
    }

    enum class Volume {
        TOP,
        BOTTOM,
        ALL,
        SMOOTH_ALL
    }
}
