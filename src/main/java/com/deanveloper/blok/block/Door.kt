package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Data
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

/**
 * Represents a door
 *
 * @author Dean B
 */
class Door @JvmOverloads constructor(
    val isItem: Boolean = true,
    var type: DoorType = Door.DoorType.OAK,
    override var facing: SidewaysDirection = SidewaysDirection.NORTH,
    override var powered: Boolean = false,
    var upperPart: Boolean = false,
    var rightHinged: Boolean = false
) : ItemData, BlockData, Rotatable<SidewaysDirection>, Powerable {
    override val id: String
        get() = type.id
    override val intId: Int
        get() = if(isItem) type.intItemId else type.intBlockId
    override val extraData: Nybble
        get() {
            if(isItem) {
                return 0.toNybble()
            } else {
                val data = Nybble(0)

                if(upperPart) {
                    data[0b0001] = rightHinged
                    data[0b0010] = powered
                    data[0b1000] = true
                } else {
                    data[0b0011] = facing.asInt
                    data[0b0100] = powered
                    data[0b1000] = false
                }

                return data
            }
        }

    override fun clone() = Door(isItem, type, facing, powered, upperPart, rightHinged)


    enum class DoorType(
        val id: String,
        @Deprecated("magic") val intBlockId: Int,
        @Deprecated("magic") val intItemId: Int
    ) {
        OAK("wooden_door", 64, 324),
        SPRUCE("spruce_door", 193, 427),
        BIRCH("birch_door", 194, 428),
        JUNGLE("jungle_door", 195, 429),
        ACACIA("acacia_door", 196, 430),
        DARK_OAK("dark_oak_door", 197, 431),
        IRON("iron_door", 71, 330)
    }
}
