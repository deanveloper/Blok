package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.BOOLEAN_MAPPER
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage
import com.deanveloper.blok.util.toNybble

/**
 * Represents a door
 *
 * @author Dean B
 */
class Door @JvmOverloads constructor(
        val isItem: Boolean = true,
        var type: DoorType = Door.DoorType.OAK,
        facing: SidewaysDirection = SidewaysDirection.NORTH,
        powered: Boolean = false,
        _upperPart: Boolean = false
) : ItemData, BlockData, Rotatable<SidewaysDirection>, Powerable {
    override val id: String
        get() = type.id
    override val intId: Int
        get() = if (isItem) type.intItemId else type.intBlockId
    override var rawData = Nibble()

    override var facing: SidewaysDirection by NibbleStorage(0b0011, facing) {
        if(upperPart) {
            TODO()
        } else {
            SidewaysDirection.fromInt(it)
        }
    }

    override var powered: Boolean by NibbleStorage(0b0110, powered) {
        BOOLEAN_MAPPER(if(upperPart) it else it ushr 1)
    }

    var upperPart: Boolean by NibbleStorage(0b1000, _upperPart, BOOLEAN_MAPPER)

    override fun clone() = Door(isItem, type, facing, powered, upperPart)


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
