package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

/**
 * @author Dean B
 */
class Stairs(
    var type: StairType,
    override var facing: SidewaysDirection = SidewaysDirection.EAST,
    var upsideDown: Boolean = false
) : BlockData, ItemData, Rotatable<SidewaysDirection> {
    override val id = type.id
    override val intId = type.intId
    override val rawData: Nybble
        get() {
            val data: Nybble = facing.asInt.toNybble()
            data[0b0100] = upsideDown

            return data
        }

    init {
        this.facing = facing
    }

    override fun clone() = Stairs(type, facing, upsideDown)

    enum class StairType(val id: String, val intId: Int) {
        OAK("oak_stairs", 53),
        COBBLESTONE("stone_stairs", 67),
        BRICK("brick_stairs", 108),
        STONE_BRICK("stone_brick_stairs", 109),
        NETHER_BRICK("nether_brick_stairs", 114),
        SANDSTONE("sandstone_stairs", 128),
        SPRUCE("spruce_stairs", 134),
        BIRCH("birch_stairs", 135),
        JUNGLE("jungle_stairs", 136),
        QUARTZ("quartz_stairs", 156),
        ACACIA("acacia_stairs", 163),
        DARK_OAK("dark_oak_stairs", 164),
        RED_SANDSTONE("red_sandstone_stairs", 180),
        PURPUR("purpur_stairs", 203)
    }
}
